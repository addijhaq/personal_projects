package com.company;

/**
 * Created by addisonulhaq on 2/25/17.
 */
public class Song {
    private String artist;
    private String title;
    private String lyrics;


    public Song(String artist, String title, String lyrics){
        this.artist = artist;
        this.title  = title;
        this.lyrics = lyrics;

    }

    public String getArtist() {
        return artist;
    }

    public String getLyrics() {
        return lyrics;
    }

    public String getTitle(){
        return title;
    }

    public String toString() {
        return title;
    }

}