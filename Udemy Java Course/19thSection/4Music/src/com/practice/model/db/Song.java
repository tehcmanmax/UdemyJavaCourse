package com.practice.model.db;

public class Song {

    private int id;
    private int track;
    private int album;
    private String title;

    public int getId(){
        return id;
    }

    public int getTrack(){
        return track;
    }

    public int getAlbum(){
        return album;
    }

    public String getTitle(){
        return title;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTrack(int track){
        this.track = track;
    }

    public void setAlbum(int album){
        this.album = album;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
