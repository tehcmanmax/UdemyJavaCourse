package com.practice;

public class Main {

    public static void main(String[] args) {
        SimpleCalculator calc = new SimpleCalculator();

        calc.setFirstNumber(4); //this is preffered over the next line
        calc.secondNumber = 6;
        System.out.println(calc.getAdditionResult());

    }
}

