package com.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*TASKS
 * 1. Implement removeAll()
 * 2. Implement containsAll()
 * */
public class Main {

    public static void main(String[] args){
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();
        for(int i = 1; i <= 8; i++){
            squares.add(i * i);
            cubes.add(i * i * i);
        }
        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes.");


        //        performing the Union and Intersection operations
        Set<Integer> union = new HashSet<>(squares);
        Set<Integer> intersection = new HashSet<>(squares);


        union.addAll(cubes);
        System.out.println("Union has: ");
        for(Integer i : union){
            System.out.println(i);
        }

        System.out.println("Union contains " + union.size() + " elements"); // takes all elements from 2 sets without duplicates

        intersection.retainAll(cubes);

        System.out.println("Intersection has: ");
        for(Integer i : intersection){
            System.out.print(i + " ");
        }
        System.out.println("Intersection contains " + intersection.size() + " elements"); // takes only duplicate elements from 2 sets

        System.out.println("------------------------------------------------------------------");

        String randomString = "Apple Orange Is I'm";
        String[] convertedString = randomString.split(" "); // converting to the String array using the string delimiter
        System.out.println("Checking whether the Arrays.split() works:");
        System.out.println(Arrays.toString(convertedString)); // prints the array without looping

        System.out.println("------------------------------------------------------------------");

        //        Using Arrays.asList
        String[] randomStringArray = {"Hello", "World", "I love", "Sets", "Theory"};
        Set<String> takesArray = new HashSet<>(Arrays.asList(randomStringArray));

        System.out.println("Checking whether the Arrays.asList() works:");
        for(String s : takesArray){
            System.out.print(s + " ");
        }

        System.out.println("\n------------------------------------------------------------------");

        //      Asymmetric set difference
        String[] banana = {"yellow", "fruit", "tasty", "fresh", "cheap"};
        String[] orange = {"orange", "fruit", "tasty", "fresh", "expensive"};

        Set<String> bananaCharacteristics = new HashSet<>(Arrays.asList(banana));
        Set<String> orangeCharacteristics = new HashSet<>(Arrays.asList(orange));

        Set<String> asymmetricDifference = new HashSet<>(bananaCharacteristics);
        asymmetricDifference.removeAll(orangeCharacteristics);

        for(String s : asymmetricDifference){
            System.out.print(s + " ");
        }
        System.out.println("\n------------------------------------------------------------------");

        //        symmetric set difference
        String[] sun = {"white", "hot", "big", "centered"};
        String[] pluto = {"white", "cold", "small", "outskirt"};

        Set<String> sunCharacteristics = new HashSet<>(Arrays.asList(sun));
        Set<String> plutoCharacteristics = new HashSet<>(Arrays.asList(pluto));

        Set<String> union2 = new HashSet<>(sunCharacteristics);
        union2.addAll(plutoCharacteristics);

        Set<String> intersection2 = new HashSet<>(sunCharacteristics);
        intersection2.retainAll(plutoCharacteristics);
        union2.removeAll(intersection2);

        Set<String> symmetricDifference = new HashSet<>(union2);
        for(String s : symmetricDifference){
            System.out.print(s + " ");
        }
        System.out.println("\n------------------------------------------------------------------");

        //        set difference
        String[] setString = {"computer", "game", "mouse", "keyboard", "food"};
        String[] subSetString = {"mouse", "food"};

        Set<String> set = new HashSet<>(Arrays.asList(setString));
        Set<String> subSet = new HashSet<>(Arrays.asList(subSetString));

        System.out.println(set.containsAll(subSet));
    }
}
