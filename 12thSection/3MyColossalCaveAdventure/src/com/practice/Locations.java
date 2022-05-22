package com.practice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location>   { // without this implementation, Main class won't be able to use methods from this class
    /*Why are we implementing Map interface in this code rather than just creating an object of type Map?
    Also if I just create an object, then can I also override different methods of that interface from which the object was created?
    yes you can override. but no that would be exposing map to outside world and you dont want that because it breaks encapsulation and anyone can do whatever he wants and break all code. Yes basically custom map, that delegates all operations to internal map.

In most cases you would provide only methods that you need and never expose the collection.

Cheers.
    */

    private static Map<Integer, Location> locations = new HashMap<>();
    public static void main(String[] args) throws IOException{
        try(FileWriter locFile = new FileWriter("locations.txt");
            FileWriter dirFile = new FileWriter("directions.txt")) {
            for(Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for(String direction : location.getExits().keySet()) {
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
            }
        }
    }

    static{ //means it will be one static copy
        Map<String, Integer> tempExit = new HashMap<String, Integer>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", null));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExit));

    }




/*  TOO VERBOSY; JAVA 7 GIVES THE SIMPLE WAY OF DOING THE SAME THING
    FileWriter fileWriter = null;

    {
        try{
            fileWriter = new FileWriter("description of locations.txt");
            for(Location loc : locations.values()){ // values() returns both  key and value sets
                fileWriter.write(loc.getLocationID() + " " + loc.getDescription() + "\n");
            }
        }
        catch(IOException e){
            System.out.println("From the catch");
            e.printStackTrace();
        }
        finally{
            try{
                System.out.println("From the finally");
                fileWriter.close();
            }
            catch(IOException e){
                System.out.println("From the finally, catch");
                e.printStackTrace();
            }
        }
    }*/


    @Override
    public int size(){
        return locations.size();
    }

    @Override
    public boolean isEmpty(){
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key){
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value){
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key){
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value){
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key){
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m){

    }

    @Override
    public void clear(){
        locations.clear();

    }

    @Override
    public Set<Integer> keySet(){
        return locations.keySet();
    }

    @Override
    public Collection<Location> values(){
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet(){
        return locations.entrySet();
    }

}
