package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;

//https://www.baeldung.com/java-8-functional-interfaces
public class Main {

    public static void main(String[] args){
        System.out.println("Using usingFunctions()");
        usingFunctions();

        System.out.println("Using usingSupplier()");
        usingSupplier();

        System.out.println("Using usingConsumer()");
        usingConsumer();
    }

    static void usingConsumer(){
        List<String> names = Arrays.asList("John", "Freddy", "Samuel");
        names.forEach(name -> System.out.println("Hello, " + name)); //uses Consumer  functional interface
    }

    static void usingSupplier(){
        //        LONGER WAY
/*        Random rand = new Random(){
            @Override
            public float nextFloat(){
                return super.nextFloat() * 100;
            }
        };
        Supplier<Float> randFloatUp100 = rand::nextFloat;*/

        Random rand = new Random();
        Supplier<Float> randFloatUp100 = () -> rand.nextFloat() * 100;
        System.out.println(randFloatUp100.get());
    }


    static void usingFunctions(){
        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";

        Function<Integer, String> quoteIntToString = quote.compose(intToString);

        System.out.println(quote.apply("Max"));

        System.out.println(quoteIntToString.apply(7));
    }
}
