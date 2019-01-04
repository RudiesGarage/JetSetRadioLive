package com.example.dem.jetsetradiolive;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.session.MediaSession;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import java.io.IOException;
import java.util.Random;
import static com.example.dem.jetsetradiolive.MediaPlayerServiceManager.ACTION_INTERNET;
import static com.example.dem.jetsetradiolive.MediaPlayerServiceManager.ACTION_NEXT;
import static com.example.dem.jetsetradiolive.MediaPlayerServiceManager.ACTION_PAUSE;
import static com.example.dem.jetsetradiolive.MediaPlayerServiceManager.ACTION_PLAY;



@SuppressLint("NewApi")
//this holds the State Machine for the MediaPlayer
public class MediaSessionCallBack extends MediaSession.Callback {
    private MediaPlayer mMediaPlayer = new MediaPlayer();



    private Song currSong = new Song("","","",""); //current song
    private String currStation = "shuffle"; //current station (this is also kept to check if the current state is in shuffle)
    private PendingIntent PI;
    private Context ctx;
    private State mState = State.Retrieving; // current "STATE" of the MEDIAPLAYER state machine

    // indicates the state our service:
    enum State {
        Retrieving, // the MediaRetriever is retrieving music
        Stopped, // media player is stopped and not prepared to play
        Preparing, // media player is preparing...
        Playing, // playback active (media player ready!). (but the media player may actually be
        // paused in this state if we don't have audio focus. But we stay in this state
        // so that we know we have to resume playback once we get focus back)
        Paused,        // playback paused (media player ready!)
        Complete, //playback complete
    };



    MediaSessionCallBack(Context ctx){
        this.ctx = ctx;
        setupMediaPlayer();
    }

    public void setStation(String station){
        this.currStation = station;
    }





    @Override
    //pause the current mediaplayer
    public void onPause() {
        if (mState.equals(State.Playing)) {
            mMediaPlayer.pause();
            NotificationManager nManager = ((NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE));
            nManager.cancelAll();
            buildNotification(generateaction(R.drawable.apollo_holo_dark_play,"HELLO",ACTION_PLAY));
        }
        mState = State.Paused;

    }

    @Override
    //play the next song
    public void onPlay() {
        if (!mState.equals(State.Preparing) && !mState.equals(State.Retrieving)) {
            mMediaPlayer.start();
            NotificationManager nManager = ((NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE));
            nManager.cancelAll();
            buildNotification(generateaction(R.drawable.apollo_holo_dark_pause,"HELLO",ACTION_PAUSE));
        }
        mState = State.Playing;
    }


    //TODO impliment this
    @Override
    public void onSkipToPrevious() {
        super.onSkipToPrevious();
    }


    @Override
    public void onPlayFromSearch(String query, Bundle extras) {
        onStop();
        Song extra = (Song) extras.getSerializable("url");
        currSong = extra;
        loadSong(extra.getURL());
    }



    @Override
    //stop the musicplayer (Note: this throws a low priority error when called mid Perpare(); )
    public void onStop() {
        if (mState.equals(State.Playing)||mState.equals(State.Complete)) {
            mMediaPlayer.stop();
        }
            mState = State.Stopped;
            //unregisterReceiver(myNoisyAudioStreamReceiver);
            mMediaPlayer.reset();
    }



    //This Function plays the "Next" song beat
    public void playNext() throws IOException {
        onStop(); //stop whatever is currently playing

        //normal hit sound
        if (new Random().nextInt(7) != 0) {
            AssetFileDescriptor afd = ctx.getResources().openRawResourceFd(R.raw.hitsound);
            if (afd == null) return;
            mMediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
        }

        //special sound (1/7 chance)
        else {
            AssetFileDescriptor afd = ctx.getResources().openRawResourceFd(R.raw.killsound);
            if (afd == null) return;
            mMediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
        }
        //prepare song
        mMediaPlayer.prepareAsync();
        mState = State.Preparing;
    }



    public void setupMediaPlayer(){
        //Set the MEDIAPLAYER onPREPARED LISTENER
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){

            //When the mediaplayer is prepared...
            @Override
            public void onPrepared(MediaPlayer mp) {
                if(!mState.equals(State.Stopped) && !mState.equals(State.Paused) ) {
                    //check that the state was not changed when the session was preparing
                    mState = State.Playing;
                    onPlay(); //start the music
                }
            }
        });

        //Ser the MEDIAPLAYER onCompletionListener
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                onStop();//Stop the music
                mState = State.Complete;
                NewSongReuest();//load next song
            }
        });
    }

    //Initialize mediaplayer with a url
    private void loadSong(String url) {
        try {
            mMediaPlayer.setDataSource(url);
        } catch (IllegalArgumentException e) {
            // ...
        } catch (IllegalStateException e) {
            // ...
        } catch (IOException e) {
            // ...
        }
        try {
            mMediaPlayer.prepareAsync(); // prepare async to not block main thread
        } catch (IllegalStateException e) {
            // ...
        }
        mState = State.Preparing;
    }


    //This function sends and intent to the FIREBASE CONTROLLER REQUEST A NEW SONG
    public void NewSongReuest(){

        if(isNetworkStatusAvialable()){
            Intent mMediaplayerServiceIntent = new Intent(ctx,Firebase_Controller.class);
            mMediaplayerServiceIntent.putExtra("STATION",currStation);
            mMediaplayerServiceIntent.putExtra("ORIGIN","NewSongRequest");
            ctx.startService(mMediaplayerServiceIntent);
        }else{
            Intent mMediaplayerServiceIntent = new Intent(ctx,MediaPlayerServiceManager.class);
            mMediaplayerServiceIntent.setAction(ACTION_INTERNET);
            ctx.startService(mMediaplayerServiceIntent);
        }


    }



    @SuppressLint("NewApi")
    private void buildNotification(Notification.Action action){
        Notification.MediaStyle style = new Notification.MediaStyle();

        Intent intent = new Intent(ctx,MediaPlayerServiceManager.class);
        intent.setAction(ACTION_PAUSE);
         PI = PendingIntent.getService(ctx,1,intent,0);

        Notification.Builder builder = new Notification.Builder(ctx)
                .setSmallIcon(R.drawable.future).setContentTitle(currSong.gettitle()).setContentText(currSong.getartist()).setDeleteIntent(PI).setStyle(style);

        //builder.addAction(generateaction(android.R.drawable.arrow_up_float, "Previous", ACTION_PREV ));
        builder.addAction(action);
        builder.addAction(generateaction(R.drawable.apollo_holo_dark_next, "Next", ACTION_NEXT));

        style.setShowActionsInCompactView(0,1);


        NotificationManager notificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,builder.build());
    }


    @SuppressLint("NewApi")
    private Notification.Action generateaction(int icon, String title, String intentAction){
        Intent intent = new Intent(ctx,MediaPlayerServiceManager.class);
        intent.setAction(intentAction);
         PI = PendingIntent.getService(ctx,1,intent,0);
        return new Notification.Action.Builder(icon,title,PI).build();
    }


    //check if network is available
    private  boolean isNetworkStatusAvialable () {
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null)
        {
            NetworkInfo netInfos = connectivityManager.getActiveNetworkInfo();
            if(netInfos != null)
                if(netInfos.isConnected())
                    return true;
        }
        return false;
    }

    public void kill(){
        onStop();
        mMediaPlayer.release();

    }
}
