package com.example.dem.jetsetradiolive;

import android.annotation.SuppressLint;

import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.io.IOException;

//THIS IS THE MANAGER FOR DATA RadioFragment and MediaSessionCallBack
public class MediaPlayerServiceManager extends Service {

    private Song prevSong = new Song("","","",""); //previous song

    // TODO add a stack of prev songs
    // on new song push to the stack
    // on previous pop the stack
    //if stack is empty get a new song

    private Song currSong = new Song("","","",""); //current song
    private AudioManager myAudioManager;
    private final Handler handler = new Handler(); //
    private TelephonyManager tm;
    private Intent intent;


    private IntentFilter intentFilter = new IntentFilter(AudioManager.ACTION_AUDIO_BECOMING_NOISY);


    public static final String ACTION_UI = "action_UI";
    public static final String ACTION_PLAY = "action_play";
    public static final String ACTION_PAUSE = "action_pause";
    public static final String ACTION_PREV = "action_prev";
    public static final String ACTION_NEXT = "action_next";
    public static final String ACTION_REC = "action_receive";
    public static final String ACTION_STATION = "action_station";
    public static final String ACTION_INTERNET = "action_internet";


    private MediaSessionCallBack MSCB;
    private MediaController mController;
    private MediaSession mSession;



    //CALLED WHEN SERVICE IS CREATED
    @SuppressLint("NewApi")
    @Override
    public void onCreate() {
        initMediaSession();

        //AUDIO MANAGER to handle audio focus
        myAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        myAudioManager.requestAudioFocus(new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int focusChange) {
                switch (focusChange) {
                    case AudioManager.AUDIOFOCUS_GAIN:
                        //TODO music player should keep the state it was prior to any phone call / losing audio focus
                        //mController.getTransportControls().play();
                        mController.getTransportControls().pause();
                        break;
                    case AudioManager.AUDIOFOCUS_LOSS:
                        mController.getTransportControls().pause();
                        break;
                    case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                        mController.getTransportControls().pause();
                        break;
                    case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                        mController.getTransportControls().pause();
                        // ... pausing or ducking depends on your app
                        break;

                }
            }
        }, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

        tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        tm.listen(mPhoneListener, PhoneStateListener.LISTEN_CALL_STATE);
        super.onCreate();
    }

    //initialize MEDIASESSIONCALLBACK
    @SuppressLint("NewApi")
    public void initMediaSession(){
        //mMediaPlayer = new MediaPlayer();
        mSession = new MediaSession(getApplicationContext(),"JET SET RADIOOOO!");

        mController = new MediaController(getApplicationContext(),mSession.getSessionToken());

        MSCB = new MediaSessionCallBack(getApplicationContext());

        mSession.setCallback(MSCB);
    }


    //This handles unplug of Headphones signal from the OS
    private BroadcastReceiver myNoisyAudioStreamReceiver = new BroadcastReceiver(){
        @SuppressLint("NewApi")
        @Override
        public void onReceive(Context context, Intent intent) {
            if (AudioManager.ACTION_AUDIO_BECOMING_NOISY.equals(intent.getAction())) {
                mController.getTransportControls().pause();
            }
        }
    };


    //Handle phone calls
    private PhoneStateListener mPhoneListener = new PhoneStateListener() {
        @SuppressLint("NewApi")
        public void onCallStateChanged(int state, String incomingNumber) {

                switch (state) {
                    //if phone rings
                    case TelephonyManager.CALL_STATE_RINGING:
                        // do something...
                        mController.getTransportControls().pause();
                        break;

                        //if phone calling
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        // do something...
                        mController.getTransportControls().pause();
                        break;

                        //otherwise...
                    case TelephonyManager.CALL_STATE_IDLE:
                        // do something...
                        //mController.getTransportControls().play();
                        mController.getTransportControls().pause();
                        //TODO FIX BUG where if musicplayer is paused, and call is recieved, on end of that call the musicplayer will start
                        //TODO music player should keep the state it was prior to any phone call / losing audio focus

                        break;
                    default:
                        Log.d("ERROR", "Unknown phone state=" + state);

                }
        }
    };

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @SuppressLint("NewApi")
    @Override
    public boolean onUnbind(Intent intent) {
        mSession.release();
        return super.onUnbind(intent);
    }

    //Called whenever we "restart" this service
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(myAudioManager == null){
            initMediaSession();
        }
        handleIntent(intent);

        return START_STICKY;
    }

    //send UPDATES TO UI
    private Runnable sendUpdatesToUI = new Runnable() {
        public void run() {
            intent = new Intent(ACTION_UI);
            intent.putExtra("ORIGIN","UPDATEUI");
            intent.putExtra("TITLE",currSong.gettitle());
            intent.putExtra("ARTIST", currSong.getartist());
            sendBroadcast(intent);
        }
    };

    private Runnable NoInternetHandler = new Runnable() {
        public void run() {
            intent = new Intent(ACTION_INTERNET);
            sendBroadcast(intent);
        }
    };


    //Called when app dies
    @Override
    public void onDestroy() {
        try{
            unregisterReceiver(myNoisyAudioStreamReceiver);
        }
        catch(IllegalArgumentException e) {
            Log.e("RECEIVER","UNREGISTER FAIL");
        }

        MSCB.kill();
        stopSelf();
        super.onDestroy();
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        try{
            unregisterReceiver(myNoisyAudioStreamReceiver);
        }
        catch(IllegalArgumentException e) {
            Log.e("RECEIVER","UNREGISTER FAIL");
        }

        MSCB.kill();
        NotificationManager nManager = ((NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE));
        nManager.cancelAll();
        stopSelf();
    }



    @SuppressLint("NewApi")
    private void handleIntent(Intent intent){
        if(intent == null || intent.getAction() == null  ){
            return;
        }
        String action = intent.getAction();
        switch(action){

            //play song from notification
            case ACTION_PLAY:
                registerReceiver(myNoisyAudioStreamReceiver, intentFilter);
                mController.getTransportControls().play();
                break;

            //pause song from notification
            case ACTION_PAUSE:
                try{
                    unregisterReceiver(myNoisyAudioStreamReceiver);
                }
                catch(IllegalArgumentException e) {
                    Log.e("RECEIVER","UNREGISTER FAIL");
                }

                mController.getTransportControls().pause();
                break;

            //get next song from notification or by tapping
            case ACTION_NEXT:

                registerReceiver(myNoisyAudioStreamReceiver, intentFilter);
                //pressed by tapping
                try {
                    MSCB.playNext();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //otherwise its a station change, and request a new song

                break;
            case ACTION_STATION:
                registerReceiver(myNoisyAudioStreamReceiver, intentFilter);
                String temp = intent.getStringExtra("STATION");

                MSCB.setStation(temp);

                MSCB.NewSongReuest();


                break;
            //get previous song from notification
            case ACTION_PREV:
                mController.getTransportControls().skipToPrevious();
                break;

            //handle a received song
            case ACTION_REC:
                currSong = (Song) intent.getSerializableExtra("SONG");

                //TODO add a check if the new song is the same as the song just played

                //update UI
                handler.removeCallbacks(sendUpdatesToUI);
                handler.postDelayed(sendUpdatesToUI, 0);

                Bundle b = new Bundle();
                b.putSerializable("url",currSong);
                mController.getTransportControls().playFromSearch("URL",b);

                break;
            case ACTION_INTERNET:
                handler.removeCallbacks(sendUpdatesToUI);
                handler.postDelayed(sendUpdatesToUI, 0);


                break;
            default:
                Log.e("ACTION",action);
        }
    }


}
