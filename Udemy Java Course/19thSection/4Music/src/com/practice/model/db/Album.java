package com.practice.model.db;

public class Album {
    private int id;
    private String name;
    private int artist;

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getArtist(){
        return artist;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setArtist(int artist){
        this.artist = artist;
    }
}
