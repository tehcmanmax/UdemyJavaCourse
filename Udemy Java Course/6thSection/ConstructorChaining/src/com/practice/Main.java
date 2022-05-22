/*best way of using constructor overloading*/

package com.practice;

class Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;

    //1st constructor
    public Rectangle() {
        this(0,0);
        //    calls 2nd contsr
    }

    //    2nd constructor
    public Rectangle(int width, int height) {
        this(0,0, width, height);
        //    calls 3rd contsr
    }

    //    3rd constructor. does all the work
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

}


public class Main {

    public static void main(String[] args) {
    Rectangle figure = new Rectangle();
    Rectangle figure2 = figure; //referencing the figure instance

    figure2.setX(2);

        System.out.printf("%d %d %d %d\n", figure.getHeight(), figure.getWidth(), figure.getX(), figure.getY());
        System.out.println(figure2.getX());
    }
}
