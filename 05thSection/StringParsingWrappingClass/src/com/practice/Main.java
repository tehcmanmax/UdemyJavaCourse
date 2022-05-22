package com.practice;

public class Main {

    public static void main(String[] args) {
        String numString = "12";
        System.out.println("string num has a string value: " + numString);
        System.out.println("numbString + 1: " + numString + 1);

//        parsing. WRAPPING CLASS concept!
        double num = Double.parseDouble(numString);
/*
calling the class Double and the method parseDouble that takes an argument
it is important to call the class that match with primitive data type!
 e.x. to convert string into float. init float with a help of Float class
*/
        num++;
        System.out.println("parsed num + 1: " + num);

    }
}
