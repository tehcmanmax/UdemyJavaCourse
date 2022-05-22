package com.practice;

public class Main {

    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        System.out.println(max);
        int max1 = 1_000;
        System.out.println(max1);
        double pound = .45259237d;
        int amountChicken = 3;

        double convertedKG = (double)(pound * amountChicken);
        System.out.printf("converted KG is %.3f", convertedKG);
    }
}