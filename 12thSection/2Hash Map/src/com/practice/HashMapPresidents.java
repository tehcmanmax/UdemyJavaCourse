package com.practice;

import java.lang.reflect.Field;
import java.util.*;

public class HashMapPresidents extends HashMap<String, String> {
    private static int countsInstanceNames;
    private int fieldPosition = -1;

    private final Map<String, String> peopleCharacteristics;

    public HashMapPresidents() {
        this.peopleCharacteristics = new HashMap<>();
        this.givesInstancePosition();
    }

    public Map<String, String> getPeopleCharacteristics() {
        System.out.println(this.getTheInstanceName());
        return peopleCharacteristics;
    }

    // making put() adding a unique key
    @Override
    public String put(String key, String value) { // I cannot change the return type
        if(!this.peopleCharacteristics.containsKey(key)) {
            this.peopleCharacteristics.put(key, value);
            System.out.println(key + "  --->  added");
        } else {
            System.out.println("Sorry. " + key + " is already in the Hash Map");
        }
        return ""; //I have to return an object, or a String object
    }

    @Override
    public String remove(Object key) {
        return super.remove(key);
    }

    @Override
    public String toString() {
        return "HashM_pplCharacteristics{" + "peopleCharacteristics=" + peopleCharacteristics + '}';
    }

    private String getTheInstanceName() {
        Field[] declaredFields = Main.class.getDeclaredFields();
        Field f = declaredFields[fieldPosition];
        return "\nObject name: " + f.getName();
    }

    private void givesInstancePosition() { // grouping two fields in order to prevent an accident modification
        HashMapPresidents.countsInstanceNames++;
        this.fieldPosition += HashMapPresidents.countsInstanceNames;
    }

    /* ITERATING THROUGH THE FIELDS
    private static String getTheInstanceName() {
        for(Field f : Main.class.getDeclaredFields()) {
            if(f.getType().equals(HashM_pplCharacteristics.class))//Here you would retrieve the variable name when the type is dieselEngine.
                return f.getName();
        }
        return null; //actually, it will never happen
    }*/
}
