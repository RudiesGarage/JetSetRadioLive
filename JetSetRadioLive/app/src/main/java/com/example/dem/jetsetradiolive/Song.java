package com.example.dem.jetsetradiolive;

import java.io.Serializable;

//This class handles all song data
public class Song implements Serializable {
    private String URL = "";
    private String Title = "";
    private String Artist = "";
    private String Station = "";

    public Song(){

    }

    public Song(String url,String title, String artist,String Station){
        this.URL = url;
        this.Title = title;
        this.Artist = artist;
        this.Station = Station;
    }

    public String getURL(){
        return this.URL;
    }

    public String getStation(){return this.Station;}

    public String gettitle(){
        return this.Title;
    }

    public String getartist(){
        return this.Artist;
    }


    //TODO write a equals function that compares itself to another song

}
