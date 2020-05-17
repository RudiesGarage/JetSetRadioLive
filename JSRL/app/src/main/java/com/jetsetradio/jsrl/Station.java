package com.jetsetradio.jsrl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Station implements Serializable {
    @SerializedName("station")
    private String Name;
    @SerializedName("songlist")
    private String[] Playlist;
    @SerializedName("logo")
    private int station_logo;



    public Station(String name,String[] playlist,int logo) {
        this.Name = name;
        this.Playlist = playlist;
        this.station_logo = logo;
    }

    public int getStation_logo(){
        return station_logo;
    }
//
    public void setStation_logo(int logo){
        this.station_logo = logo;
    }

    public String getStationName(){
        return this.Name;
    }


    public String[] getPlaylist(){
        return this.Playlist;
    }

    public int getNumSongs(){
        return this.getPlaylist().length;
    }

    public Song getSong(int i){
        return new Song(this.Playlist[i]);
    }

    public Song getRandomSong(){
        Random rand = new Random();
        int n = rand.nextInt(this.getNumSongs());
        String src = this.Playlist[n];
        return new Song(src);
    }


}

