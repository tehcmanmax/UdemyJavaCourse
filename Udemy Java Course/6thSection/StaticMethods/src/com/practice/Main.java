package com.practice;

import java.rmi.UnexpectedException;

class Calculator{
    public static void printSum(int x, int y){
        System.out.println("Sum is: "+(x+y));
    }
}

public class Main {

    public static void main(String[] args) {
	    Calculator.printSum(5,6);

        University Jagielonka = new University("Jagielonka");
        University UAM = new University("Uniwersytet Adama Mickiewicza");

        UAM.printUniName();
        Jagielonka.printUniName();


	    printGoodbye();
    }


    public static void printGoodbye(){
        System.out.println("Goodbye");
    }
}
