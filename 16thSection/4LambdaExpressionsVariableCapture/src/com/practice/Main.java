package com.practice;

class LambdaExpressionClass {
    //I can reference member or static variables without caveats
    private String greeting = "Hello there";
    private static String bye = "Goodbye!";

    public void doStuff(String noun){
        int pass = 12; // i cannot increment it

        StupidMethod stupidMethod = (text) -> { //it does not run authomatically, i need the call of the lembda variable stupidMethod
            System.out.println(greeting + ", " + noun + "\n" + bye);
            System.out.println("Your account pass: " + pass);
        };

        stupidMethod.stupid(noun);
    }
}

interface StupidMethod {
    void stupid(String text);
}

public class Main {

    public static void main(String[] args){
        LambdaExpressionClass lambdaExpressionClass = new LambdaExpressionClass();
        lambdaExpressionClass.doStuff("Maksym");
    }
}
