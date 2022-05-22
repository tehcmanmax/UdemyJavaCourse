package com.practice;

public class Cat extends LandAnimal implements CanJumping {

    public Cat(String animalName) {
        super(animalName);
    }

    @Override
    public void move() {
        System.out.println("Swinging while walking just as normal cat");
    }

    @Override
    public void jump() {
        System.out.println("I can reach this shelf with an ease!");
    }
}
