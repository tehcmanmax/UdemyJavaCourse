package com.practice;
/*IT IS NOT A FUNCTIONAL INTERFACE
* */


//@FunctionalInterface
public interface DiamondProblem {

    //The following methods do not require implantation since they are default
    default void test1(){}
    default void test2(){}


    default void diamondProblem(){
        System.out.println("From DiamondProblem Interface");
    }
}
