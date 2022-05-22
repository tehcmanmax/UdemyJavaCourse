package com.practice;

import java.util.Scanner;

// Write a small program to read an integer from the keyboard
// (using Scanner) and print out the times table for that number.
// The table should run from 1 to 12.
//
// You are allowed to use one variable called scanner for your
// Scanner instance. You can use as many other variables as you
// need, but they must must all be called x. That includes any
// class instances and loop control variables that you may decide
// to use.
//
// If you use a class, the class can be called X (capital), but
// any instances of it must be called x (lower case).
//
// Any methods you create must also be called x.
//
// Optional Extra:
// Change your program so that ALL variables (including the scanner
// instance) are called x.

public class X {
    private static int x;

    // I cannot use the instance fields from the static context (because I cannot use static method via instance)!!!
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("Please a number that you want to multiply in the range of 1-12");
        X.x = x.nextInt();
        X.x();
    }

    public static void x() {
        for(int x = 1; x <= 12; x++) {
            System.out.println(x * X.x);
        }
    }
}
