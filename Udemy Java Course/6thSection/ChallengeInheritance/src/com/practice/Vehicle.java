package com.practice;

public class Vehicle {
    private String name;
    private int currentVelocity;
    private int currentDirection;

    public Vehicle(String name) {
        this.name = name;
        this.currentVelocity = 0;
        this.currentDirection = 0;
    }

    public void steer(int direction){
        this.currentDirection+=direction;
        System.out.println("Vehicle.steer() moving at" +currentDirection+" degrees.");
    }
    public void move(int velocity, int direction){
        currentVelocity=velocity;
        currentDirection= direction;
        System.out.println("Vehicle move() moving at"+currentVelocity+" in directino "+ currentDirection);
    }

    public void stop(){
        this.currentVelocity = 0;
    }


    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }
}
