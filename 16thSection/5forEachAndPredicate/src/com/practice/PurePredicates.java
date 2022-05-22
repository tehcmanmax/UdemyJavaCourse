package com.practice;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;

public class PurePredicates {

    public static void main(String[] args){
        IntPredicate greaterThan10 = i /*argument that is passed to the method in the interface*/ -> i > 10;

        System.out.println("greaterThan10; result: " + greaterThan10.test(10));

        IntPredicate lessThan100 = i -> i < 100;


        System.out.println("greaterThan10.and(greaterThan10) result: " + greaterThan10.and(lessThan100).test(90));

        IntPredicate negatedLessThan100 = lessThan100.negate();
        System.out.println("negatedLessThan100;greaterThan10.or(negatedLessThan100) result: " + greaterThan10.or(negatedLessThan100).test(12));


    }
}
