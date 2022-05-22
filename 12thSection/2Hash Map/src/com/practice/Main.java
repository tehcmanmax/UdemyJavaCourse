package com.practice;
// Add the unique keys into the HashMap, and throw the message if the key already exists
// Prints the object names

import java.util.*;

/*TASKS
 * 1. Polish semantics +
 * 2. ?Modify for loop +
 * 3. Rename class to HASHMAP presidents +
 * 4. ?Print the field name and the class members in another way +
 * */
public class Main {

    static HashMapPresidents presidents = new HashMapPresidents();
    static HashMapPresidents europePresidents = new HashMapPresidents();
    static HashMapPresidents test = new HashMapPresidents();


    public static void main(String[] args) {
        Map<Integer, String> test2 = new HashMap<>();

        System.out.println(test2.put(1,"Apple")); //null means it is unique value
        System.out.println(test2.put(2,"Banana"));
        System.out.println(test2.put(1, "Orange")); //value means it was overwritten

        System.out.println(test2);

        /////////////////////////////////////////////////////////////////////////////
        presidents.put("Biden", "Liberal");
        presidents.put("Biden", "US");
        presidents.put("Biden", "Liberal");

        europePresidents.put("Andrzej Duda", "Poland");

        test.put("Kim Jin Ung", "NK");

        System.out.println(test.getPeopleCharacteristics());
        System.out.println(presidents.getPeopleCharacteristics());
        System.out.println(europePresidents.getPeopleCharacteristics());

    }
}
