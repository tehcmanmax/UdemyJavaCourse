package com.practice;

class Object{
    private int x;
    private int y;

    public Object(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Rectangle extends Object{
    private int width;
    private int height;

    public Rectangle() {
        this (0,0);
    }

    public Rectangle(int x, int y) {
        this(x, y, 0, 0);
    }

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

public class Main {


    public static void main(String[] args) {
        Rectangle object = new Rectangle(1,3 );
        System.out.printf("y: %d \nx: %d \nwidth: %d \nheight: %d", object.getY(), object.getX(), object.getWidth(), object.getHeight());
    }
}
