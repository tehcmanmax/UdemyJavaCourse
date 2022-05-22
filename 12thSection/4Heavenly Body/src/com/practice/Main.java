package com.practice;

import java.util.*;

/*
 * Properties:
 * 1. ?HeavenlyBody class is immutable (no final keyword for the class)
 * */

public class Main {
    private final static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private final static HashSet<HeavenlyBody> planets = new HashSet<>();


    public static void main(String[] args){
        HeavenlyBody twice = new HeavenlyBody("Added twice", 88);
        HeavenlyBody twice1 = new HeavenlyBody("Added twice", 88);
        System.out.println(Main.planets.add(twice));
        System.out.println(Main.planets.add(twice1));

        HeavenlyBody test = new HeavenlyBody("Added once", 88);
        Main.solarSystem.put(test.getName(), twice);
        Main.planets.add(test);
        HeavenlyBody obj = test;
        Main.solarSystem.put(obj.getName(), obj);
        Main.planets.add(obj);


        twice = new HeavenlyBody("Earth", 365);
        Main.solarSystem.put(twice.getName(), twice);
        Main.planets.add(twice);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);

        Main.solarSystem.put(tempMoon.getName(), tempMoon);
        twice.addMoon(tempMoon);


        twice = new HeavenlyBody("Mars", 687);
        Main.solarSystem.put(twice.getName(), twice);
        Main.planets.add(twice);

        tempMoon = new HeavenlyBody("Phobos", 0.125);
        Main.solarSystem.put(tempMoon.getName(), tempMoon);
        twice.addMoon(tempMoon);

        tempMoon = new HeavenlyBody("Deimos", 1.25);
        Main.solarSystem.put(tempMoon.getName(), tempMoon);
        twice.addMoon(tempMoon);

        twice = new HeavenlyBody("Jupiter", 4380);
        Main.solarSystem.put(twice.getName(), twice);
        Main.planets.add(twice);

        tempMoon = new HeavenlyBody("Io", 21);
        Main.solarSystem.put(tempMoon.getName(), tempMoon);
        twice.addMoon(tempMoon);

        Main.printPlanets();
        Main.printMoons();

    }

    private static void printPlanets(){
        System.out.println("All planets:");
        for(HeavenlyBody obj : Main.planets){
            System.out.println(obj.getName());
        }
    }


    private static List<HeavenlyBody> makingSetOfMoons(){
        List<HeavenlyBody> moons = new ArrayList<>();
        for(HeavenlyBody planet : Main.planets){
            moons.addAll(planet.getSatellites());
        }
        return moons;
    }

    private static void printMoons(){
        List<HeavenlyBody> moons = Main.makingSetOfMoons();
        System.out.println("All moons:");
        for(HeavenlyBody moonName : moons){
            System.out.println(moonName.getName());
        }
    }


//    private static void iteratingThroughMap(){
//        //        iterating through the entries of the
//        System.out.println("All Heavenly bodies:");
//        for(Map.Entry<String, HeavenlyBody> obj : Main.solarSystem.entrySet()){
//            System.out.println(obj.getKey() + ": " + obj.getValue());
//        }
//    }
}

