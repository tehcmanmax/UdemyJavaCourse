package com.practice;

public class LandAnimal extends Animal {

    public LandAnimal(String animalName) {
        super(animalName);
    }

    @Override
    public void eat() {
        System.out.println("I eat something from Earth");
    }

    @Override
    public void move() {
        System.out.println("Moving on the ground much nicer than on another surface");
    }
}
