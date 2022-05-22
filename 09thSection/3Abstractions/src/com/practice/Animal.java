package com.practice;

public abstract class Animal {
    private String animalName;

    public Animal(String animalName) {
        this.animalName = animalName;
    }

    public abstract void eat();

    public abstract void move();

    public String getAnimalName() {
        return animalName;
    }
}
