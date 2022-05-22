package com.practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        to scan input, i need an istance!!!
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter birth year");

//        checking if input is an int!
        boolean hasNextInt = scanner.hasNextInt();
        if(hasNextInt) {
            int birthYear = scanner.nextInt();

//        HANDILING ENTER KEY ISSUE
            scanner.nextLine();

            System.out.println("Enter your name:");
            String name = scanner.nextLine();

            int age = 2020 - birthYear;
            System.out.println("Hi, " + name + "! Your age is " + age);
        }
    }
}
