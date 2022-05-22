package com.practice;

public class Car extends Vehicle {
    private int wheels;
    private int doors;
    private int gears;
    private boolean isAutomatic;


    private int currentGear;

    public Car(String name, int wheels, int doors, int gears, boolean isAutomatic, int currentGear) {
        super(name);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.isAutomatic = isAutomatic;
        this.currentGear = 0;
    }
}

