package com.practice;

public class Fish extends Animal{
    public Fish(String animalName) {
        super(animalName);
    }

    @Override
    public void eat() {
        System.out.println("I eat smaller fishes");
    }

    @Override
    public void move() {
        System.out.println("Swimming in the ocean");
    }
}
