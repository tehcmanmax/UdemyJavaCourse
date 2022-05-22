package com.practice;

public class Animal {
    private String name;
    private int brain;
    private double weightKilograms;

    public void eat(){
        System.out.println("Animal is eating");
    }
    public void move(){
        System.out.println("Animal is moving");
    }
    public void sleep(){
        System.out.println("Animal is sleeping");
    }

    public Animal(String name, int brain, double weight) {
        this.name = name;
        this.brain = brain;
        this.weightKilograms = weight;
    }

    public String getName() {
        return name;
    }

    public int getBrain() {
        return brain;
    }

    public double getWeightKilograms() {
        return weightKilograms;
    }

}

