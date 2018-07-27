package com.live.jetsetradio.JetSetRadioLive;

import java.net.URL;

/* compiled from: Song */
public class Song {
    private String f3427a;
    private String f3428b;
    private URL f3429c;

    public Song(String str, URL url) {
        String[] split = str.split("-\\s");
        if (split.length < 2) {
            this.f3428b = split[0].trim();
            this.f3427a = "Unknown Artist";
        } else {
            this.f3427a = split[0].trim();
            this.f3428b = split[1].trim();
        }
        this.f3429c = url;
    }

    public String m5905a() {
        return this.f3427a;
    }

    public String m5906b() {
        return this.f3428b;
    }

    public URL m5907c() {
        return this.f3429c;
    }

    public void m5908d() {
        this.f3428b = "(Request) " + this.f3428b;
    }

    public String toString() {
        System.out.println("Just to be sure...");
       return this.f3429c.toString();
        // return this.f3427a + " - " + this.f3428b + " (" + this.f3429c.toString() + ")";
    }
}
