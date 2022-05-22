package com.practice;
/*
* since it is a real specific car, i need to hard code in the constructor*
* */
public class FordFocus extends Car{
    private String model;
    private String brand;
    private int monthsOfUsage;

    public FordFocus( int currentGear, int monthsOfUsage) {
        super("Car", 4, 4, 5, true, currentGear);
        this.brand="Ford";
        this.model="Focus";
        this.monthsOfUsage = monthsOfUsage;

    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getMonthsOfUsage() {
        return monthsOfUsage;
    }
}
