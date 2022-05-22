package com.practice;

import java.util.function.Supplier;

/*
 * T - output data type;
 * t - data
 */
@FunctionalInterface
public interface Printer<T, R> {
    Supplier<String> askingMyself = () -> "What am I doing?"; //THIS IS TREATED AS FIELD!

    R print(T t);
    //default T take();


    default String giveMotivation(){
        return "Speed up Java core learning";
    }

    default void diamondProblem(){
        System.out.println("From Printer Interface");
    }

    static String giveDefaultMessage(){
        return "I love using static methods from interfaces";
    }

}

