package com.practice;

import com.practice.model.db.Artist;
import com.practice.model.db.Datasource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    
    public static void main(String[] args){
        
        Datasource datasource = new Datasource();
        datasource.open(Datasource.DB_NAME);
        List<Artist> artists = datasource.queryArtists(Datasource.ORDER_ASC);
        if(artists == null){
            System.out.println("Could not query");
        }
        else{
            artists.forEach(artist -> {
                System.out.print(artist.getId() + " ");
                System.out.println(artist.getName());
            });
            
        }
    
        System.out.println("albumTitleByArtistName:");
        ArrayList<String> albumTitles = datasource.albumTitleByArtistName("Led Zeppelin", Datasource.ORDER_ASC);
        albumTitles.forEach(System.out::println);
        
        //datasource.insertSong("You Shook Me 2", "Led Zeppelin", "BBC Sessions", 1);
        datasource.insertSong("Bird Dog", "Everly Brothers", "All-Time Greatest Hits", 7);
    
    
        datasource.close();
    }
}
