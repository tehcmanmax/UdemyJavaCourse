package com.practice.model.db;

import java.sql.*;
import java.util.ArrayList;

/*PLANNER

 * ERROR: I GUESS SOME SQL QUERIES OR TRANSACTION HAVE AN EEROR OR UPDATE WRONG PARAMATARIZED TYPES*/

public class Datasource {
    private int artistId;
    private int albumId;
    
    public static final String DB_NAME = "music.db";
    
    public static final String TABLE_NAME_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    
    public static final String TABLE_NAME_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    
    public static final String TABLE_NAME_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    
    public static final int ORDER_ASC = 1;
    public static final int ORDER_DESC = 2;
    public static final int ORDER_NONE = 0;
    
    //saves the time to type the query
    public static final String PREPARED_STATEMENT_ALBUM_TITLE_BY_ARTIST_NAME = "SELECT " + TABLE_NAME_ALBUMS + "." + COLUMN_ALBUM_NAME
            + " FROM " + TABLE_NAME_ALBUMS + " INNER JOIN " + TABLE_NAME_ARTISTS + " ON " + TABLE_NAME_ALBUMS + "."
            + COLUMN_ALBUM_ARTIST + " = " + TABLE_NAME_ARTISTS + "." + COLUMN_ARTIST_ID + " WHERE " + TABLE_NAME_ARTISTS + "."
            + COLUMN_ARTIST_NAME + " = ? " + " ORDER BY " + TABLE_NAME_ALBUMS + "." + COLUMN_ALBUM_NAME + " = ?";
    
    public static final String TRANSACTION_INSERT_ARTIST = "INSERT INTO " + TABLE_NAME_ARTISTS + "(" + COLUMN_ARTIST_NAME + ")" +
            " VALUES(?)";
    
    public static final String TRANSACTION_INSERT_ALBUM = "INSERT INTO " + TABLE_NAME_ALBUMS + "(" + COLUMN_ALBUM_ARTIST
            + "," + COLUMN_ALBUM_NAME + ")" + " VALUES(?,?)";
    
    public static final String TRANSACTION_INSERT_SONG = "INSERT INTO " + TABLE_NAME_SONGS + "(" + COLUMN_SONG_TRACK + ","
            + COLUMN_SONG_ALBUM + "," + COLUMN_SONG_TITLE + ")" + " VALUES(?,?,?)";
    
    
    public static final String QUERY_ARTISTS = "SELECT " + COLUMN_ARTIST_ID + " FROM " + TABLE_NAME_ARTISTS +
            " WHERE " + COLUMN_ARTIST_NAME + " = '?'";
    
    public static final String QUERY_ALBUMS = "SELECT " + COLUMN_ALBUM_ID + " FROM " + TABLE_NAME_ALBUMS +
            " WHERE " + COLUMN_ALBUM_NAME + " = '?'";
    
    public static final String QUERY_SONGS = "SELECT " + COLUMN_SONG_ID  + " FROM " + TABLE_NAME_SONGS +
            " WHERE " + COLUMN_SONG_TITLE + " = '?'";;
    
    private Connection conn;
    private PreparedStatement ByArtistName;
    
    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;
    private PreparedStatement querySong;
    
    private PreparedStatement insertIntoSongs;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoArtists;
    
    
    private int insertArtist(String name) throws SQLException {
        
        queryArtist.setString(1, name);
        ResultSet results = queryArtist.executeQuery();
        if(results.next()) {
            return results.getInt(1);
        } else {
            // Insert the artist
            insertIntoArtists.setString(1, name);
            int affectedRows = insertIntoArtists.executeUpdate();
            
            if(affectedRows != 1) {
                throw new SQLException("Couldn't insert artist!");
            }
            
            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
            if(generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for artist");
            }
        }
    }
    
    private int insertAlbum(String name, int artistId) throws SQLException {
        
        queryAlbum.setString(1, name);
        ResultSet results = queryAlbum.executeQuery();
        if(results.next()) {
            return results.getInt(1);
        } else {
            // Insert the album
            insertIntoAlbums.setInt(1, artistId);
            insertIntoAlbums.setString(2, name);
            int affectedRows = insertIntoAlbums.executeUpdate();
            
            if(affectedRows != 1) {
                throw new SQLException("Couldn't insert album!");
            }
            
            ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
            if(generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for album");
            }
        }
    }
    
    public void insertSong(String title, String artist, String album, int track) {
        
        try {
            conn.setAutoCommit(false);
            
            artistId = insertArtist(artist);
            albumId = insertAlbum(album, artistId);
            insertIntoSongs.setInt(1, track);
            insertIntoSongs.setInt(2, albumId);
            insertIntoSongs.setString(3, title);
            int affectedRows = insertIntoSongs.executeUpdate();
            if(affectedRows == 1) {
                conn.commit();
            } else {
                throw new SQLException("The song insert failed");
            }
            
        } catch(Exception e) {
            System.out.println("Insert song exception: " + e.getMessage());
            e.printStackTrace();
            try {
                System.out.println("Performing rollback");
                conn.rollback();
            } catch(SQLException e2) {
                System.out.println("Oh boy! Things are really bad! " + e2.getMessage());
            }
        } finally {
            try {
                System.out.println("Resetting default commit behavior");
                conn.setAutoCommit(true);
            } catch(SQLException e) {
                System.out.println("Couldn't reset auto-commit! " + e.getMessage());
            }
            
        }
    }
    
    public ArrayList<Artist> queryArtists(int order){
        StringBuilder sb = new StringBuilder("SELECT * FROM " + Datasource.TABLE_NAME_ARTISTS);
        if(order != ORDER_NONE){
            sb.append(" ORDER BY " + Datasource.COLUMN_ARTIST_NAME);
            if(order == ORDER_DESC) sb.append(" COLLATE NOCASE DESC");
            //else if(order == ORDER_ASC) sb.append("  COLLATE NOCASE ASC"); //either way it will be executed as ASC because of default ORDER BY
        }
        
        ArrayList<Artist> artistArrayList = new ArrayList<>();
        try(Statement statement = conn.createStatement();
            //PreparedStatement preparedStatement = conn.prepareStatement()
            ResultSet resultSet = statement.executeQuery(sb.toString())){
            while(resultSet.next()){
                Artist artist = new Artist();
                artist.setId(resultSet.getInt(Datasource.COLUMN_ARTIST_ID));
                artist.setName(resultSet.getString(Datasource.COLUMN_ARTIST_NAME));
                artistArrayList.add(artist);
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return artistArrayList;
    }
    
    //*  SELECT albums.name FROM albums INNER JOIN artists ON albums.artist = artists._id WHERE artists.name = 'Iron Maiden' ORDER BY albums.name ASC*/
    public ArrayList<String> albumTitleByArtistName(String artistName, int order){
        ResultSet resultSet = null;
        //error here; rewatch the video
        ArrayList<String> arrayListAlbumsByArtist = new ArrayList<>();
        
        try{ //shorten way of writing statement and resultSet
            ByArtistName.setString(1, artistName);
            ByArtistName.setInt(2, order);
            
            //resultSet remains null:
            resultSet = ByArtistName.executeQuery();
            
            while(resultSet.next()){
                arrayListAlbumsByArtist.add(resultSet.getString(1)); //because it just one column from resultSet:
                // (SELECT albums.name FROM..)
            }
        }
        catch(SQLException throwable){
            throwable.printStackTrace();
            return null;
        }
        return arrayListAlbumsByArtist;
        
    }
    
    public void testing(){
        try(ResultSet resultSet = conn.createStatement().executeQuery("SELECT COUNT(*) FROM " + TABLE_NAME_ARTISTS)){
            while(resultSet.next()){
                System.out.println(resultSet.getInt("COUNT(*)"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        
    }
    
    
    public boolean open(String DB_NAME){
        try{
            this.conn = DriverManager.getConnection("jdbc:sqlite:/home/max/IdeaProjects/Udemy Course/19thSection/4Music/" + DB_NAME);
            
            ByArtistName = conn.prepareStatement(PREPARED_STATEMENT_ALBUM_TITLE_BY_ARTIST_NAME);
            
            queryArtist = conn.prepareStatement(QUERY_ARTISTS);
            queryAlbum = conn.prepareStatement(QUERY_ALBUMS);
            querySong = conn.prepareStatement(QUERY_SONGS);
            
            insertIntoSongs = conn.prepareStatement(TRANSACTION_INSERT_SONG);
            insertIntoAlbums = conn.prepareStatement(TRANSACTION_INSERT_ALBUM, Statement.RETURN_GENERATED_KEYS);
            insertIntoArtists = conn.prepareStatement(TRANSACTION_INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            
            return true;
        }
        catch(SQLException e){
            System.out.println(e);
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean close(){
        try{
            if(ByArtistName != null){
                ByArtistName.close();
            }
            
            if(queryArtist != null){
                queryArtist.close();
            }
            
            if(querySong != null){
                querySong.close();
            }
            
            if(queryAlbum != null){
                queryAlbum.close();
            }
            
            if(conn != null){
                this.conn.close();
            }
            
            return true;
        }
        
        catch(SQLException e){
            System.out.println(e);
            e.printStackTrace();
            return false;
        }
    }
}
