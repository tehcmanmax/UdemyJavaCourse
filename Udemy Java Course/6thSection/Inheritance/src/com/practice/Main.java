package com.practice;

public class Main{

    public static void main(String[] args) {
	Sirko sirko = new Sirko("Grey", "Maksym", "Blue");


        System.out.println("What's my cat's color of eyes? " +
                sirko.getEyesColor());

        System.out.println("What is the owner's name and what is the color of cat's wool??" + "\nName: "+
                sirko.getCatOwnerName()+"\nColor of wool: "+
                sirko.getWoolColor());

        System.out.println("\nSirko, sleep!");
        sirko.sleep();

        System.out.println("\nSirko, voice!");
        sirko.meow();

    }
}
