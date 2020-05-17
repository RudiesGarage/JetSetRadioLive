package com.jetsetradio.jsrl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

// The contents of a song
public class Song implements Serializable {
    private String title;
    private String artist;
    private String src;

    public Song(String src){
        //  the song title and artist can be derived from the src
        this.src = src;
        // split by " - "
        String[] parts = src.split(" - ");
        // if no dash
        if(parts.length != 2){
            // artist is unknown
            this.artist = "Unknown";
            // get title from last slash
            this.title = parts[0].split("/")[6];

        }
        else{
            // get the artist from the last slash
            this.artist = parts[0].split("/")[6];

            // get the title and remove the .mp3
            this.title = parts[1].substring(0, parts[1].length() - 4);
        }
    }

    public String getArtist(){
        return this.artist;
    }

    public String getTitle(){
        return this.title;
    }

    public String getSrc(){
        return this.src;
    }

}
