package com.practice;

public class Main {
    public static void main(String[] args) {
        System.out.println(MeaninglessInitializers.getCONCATENATED());

        MeaninglessInitializers obj1 = new MeaninglessInitializers(1, 9);
        System.out.println(obj1.getFinalInstanceInitializer());

        System.out.println("\n" + MeaninglessInitializers.getCONCATENATED());
        MeaninglessInitializers obj2 = new MeaninglessInitializers();
        System.out.println(obj2.getFinalInstanceInitializer());
    }
}

