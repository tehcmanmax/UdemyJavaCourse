package com.practice;

public class Plane {
    private String pilot;
    private int wings;
    private int amountPpl;

    public Plane(String pilot, int wings, int amountPpl) {
        this.pilot = pilot;
        this.wings = wings;
        this.amountPpl = amountPpl;
    }

    private String fly(){
        return "Flying!";
    }

    @Override
    public String toString() {
        return "Plane{" +
                "pilot='" + pilot + '\'' +
                ", wings=" + wings +
                ", amountPpl=" + amountPpl +
                '}';
    }
}
