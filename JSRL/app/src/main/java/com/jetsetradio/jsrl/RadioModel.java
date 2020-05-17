package com.jetsetradio.jsrl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Observable;
import java.util.Random;

import static androidx.constraintlayout.widget.Constraints.TAG;

//@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class RadioModel extends Observable {
    private Context context; // the current context
    private Station[] stationlist; // list of stations and their playlists
    private MediaPlayer player; // the media player
    private Song currsong; //current song being played
    private int curr_station = 1; //the station index on station list
    private boolean isplaying = false; //isplaying
    private MediaPlayer.OnCompletionListener completionListener;




    public RadioModel(Context context, Station[] stationlist,MediaPlayer.OnCompletionListener completionListener){
        this.context = context;
        this.stationlist = stationlist;
        this.player = new MediaPlayer();
        this.completionListener = completionListener;

        // play song on load
        try {
            play();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getNumStations(){
        return this.stationlist.length;
    }

    public Station getStation(int i){
        return stationlist[i];
    }

    public int getCurr_station(){
        return this.curr_station;
    }

    // set new station
    public Song setStation(int newstation) throws IOException {
        // its a new station, so change music
        if(newstation != this.curr_station){
            curr_station = newstation;
            return this.play();
        }
        //if music is not playing then get a new song
        else if(!isplaying){
            return this.play();
        }
        // if same station and music is playing, dont do anything else
        else
            return currsong;
    }


    // remove the seasonal stations from the array
    public void removeSeasonal(int month){

        // convert int to string month
        String elem="";
        if(month >=4 && month <=7){
            elem = "summer";
        }
        else if(month ==8 || month==9){
            elem="halloween";
        }
        else if(month ==10 || month==11|| month == 0){
            elem="halloween";
        }

        // set up known array
        ArrayList<String> seasonal = new ArrayList<>();
        seasonal.add("summer");
        seasonal.add("halloween");
        seasonal.add("christmas");

        // remove the station to keep
        for(int j=0;j<seasonal.size();j++){
            if(seasonal.get(j).equals(elem)){
                seasonal.remove(j);
                break;
            }
        }

        // for all stations in the seasonal array remove them from the station list
        for(int k=0;k<seasonal.size();k++){

            for(int i = 0; i < this.stationlist.length; i++){
                // for the station to remove...
                if(this.stationlist[i].getStationName().equals(seasonal.get(k))){
                    // shifting elements
                    if (this.stationlist.length - 1 - i >= 0){
//                      // copy array and shift elements over
                        System.arraycopy(this.stationlist, i + 1, this.stationlist, i, this.stationlist.length - 1 - i);
                        // update station logo reference
                        this.stationlist[i].setStation_logo(i);
                    }
                    break;
                }
            }
        }
        //return the new shrunken array
        this.stationlist = Arrays.copyOf(this.stationlist, this.stationlist.length-seasonal.size());
    }


    //get play state
    public boolean isPlaying(){
        return this.isplaying;
    }

    //return current song playing
    public Song getCurrSong(){
        return this.currsong;
    }

    // fetch new music
    public Song getMusic(){
        Song mySong = this.stationlist[curr_station].getRandomSong();
        return mySong;
    }

    //    pause music
    public void pause(){
        player.pause();
        this.isplaying = false;
    }

    // resume playback
    public void resume(){
        // if paused then continue...
        if (!this.isplaying){
            player.start();
            this.isplaying = true;
        }
    }

    public Song getBump(){
        return this.stationlist[0].getRandomSong();
    }


    // play media player
    public Song play() throws IOException {

        Song mySong;
        if (new Random().nextInt(10) != 0) {
            mySong = this.getMusic();
        }
        else{
            mySong = this.getBump();
        }

        this.currsong = mySong;

        Uri songlink = Uri.parse(mySong.getSrc());
        makePlayer(songlink,this.completionListener);

        player.prepare(); //don't use prepareAsync for mp3 playback
        player.start();
        this.isplaying = true;

        return mySong;
    }

    // reset audio player
    private void makePlayer(Uri src,MediaPlayer.OnCompletionListener completionListener) throws IOException {
        this.player.reset();
        this.player.setDataSource(this.context,src);
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        this.player.setOnCompletionListener(this.completionListener);
    }



    // get next song
    public Song next() throws IOException {
        // todo play NEXT beat
        //normal hit sound
        if (new Random().nextInt(7) != 0) {
            //todo
        }
        //special sound (1/7 chance)
        else {
            //todo
        }
        // then play new song
        return this.play();
    }


}
