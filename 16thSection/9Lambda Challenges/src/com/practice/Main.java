package com.practice;

/*PAUSED ON THE SECOND CHALLENGE*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){
        //1st challenge
        rewritingAnonClassInLambda();

        //2nd challenge
        printingEvery2ndLetter2("Marshmallow");

        //3rd challenge
        System.out.println("===================================");
        Supplier<String> iLoveJava = () -> "I love Java!";
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        //4th challenge
        printAndSortItems();

        //5th
        printAndSortItemsUsingStream();

        //6th
        printAndSortItemsUsingStreamWithA();
    }

    private static void printAndSortItemsUsingStreamWithA(){
        System.out.println("===================================");
        final List<String> top2015names1 = Arrays.asList("Sophia", "jackson",
                                                         "Emma", "Aiden",
                                                         "Olivia", "liam",
                                                         "ava", "Lucas");

        int amountNamesStartWithA = (int) top2015names1.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .peek(System.out::println)
                .filter(s -> s.startsWith("A"))
                .count();

        System.out.println("Names that start with 'A' letter is " + amountNamesStartWithA);
    }

    private static void printAndSortItemsUsingStream(){
        System.out.println("===================================");
        final List<String> top2015names1 = Arrays.asList("Sophia", "jackson",
                                                         "Emma", "Aiden",
                                                         "Olivia", "liam",
                                                         "ava", "Lucas");

        List<String> top2015names2 = top2015names1.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .sorted()
                .peek(System.out::println)
                .collect(Collectors.toList());

    }

    private static void printAndSortItems(){
        System.out.println("===================================");
        final List<String> top2015names1 = Arrays.asList("Sophia", "jackson",
                                                         "Emma", "Aiden",
                                                         "Olivia", "liam",
                                                         "ava", "Lucas");

        List<String> top2015names2 = new LinkedList<>();

        top2015names1.forEach(s -> {
            String newS = s.substring(0, 1).toUpperCase() + s.substring(1);
            top2015names2.add(newS);
        });
        top2015names2.sort(String::compareTo);
        top2015names2.forEach(System.out::println);
    }


    @FunctionalInterface
    private interface InterfaceForLambda<R> {
        R lambdaMethod();
    }

    private static String printingEvery2ndLetter2(String s){
        Supplier<String> temp = () -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                if(i % 2 == 1){
                    returnVal.append(s.charAt(i));
                }
            }
            System.out.println(returnVal);
            return returnVal.toString();
        };

        return temp.get();
    }

    private static String printingEvery2ndLetter1(String s){
        System.out.println("===================================");
        /*
        * StringBuilder returnVal = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(i % 2 == 1){
                returnVal.append(s.charAt(i));
            }
        }

        return returnVal.toString();
        * */

        InterfaceForLambda<String> helper = () -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                if(i % 2 == 1){
                    returnVal.append(s.charAt(i));
                }
            }
            System.out.println(returnVal);
            return returnVal.toString();
        };

        return helper.lambdaMethod();
    }

    private static void rewritingAnonClassInLambda(){
        //REWRITE THIS
        /*
        * Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part: parts) {
                    System.out.println(part);
                }
            }
        };
        * */

        new Thread(() -> {
            System.out.println("===================================");
            String myString = "Let's split this up into an array";
            System.out.println(myString);
            String[] parts = myString.split(" ");
            for(String part : parts){
                System.out.println(part);
            }
        }).start();
    }
}
