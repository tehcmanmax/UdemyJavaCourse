package com.practice;

public class Circle {
    private double radius;

    public Circle(double radius) {
        if(radius < 0){
            this.radius = 0;
        }else {
            this.radius = radius;
        }
    }
//    I may use getters without a field
    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return (radius * radius * Math.PI); //IMPORTANT LINE! Math is a class and PI is a constant
    }
}
