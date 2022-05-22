package com.practice;

import java.util.ArrayList;

public class Sequence {
    // 0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55. // +1 +2 +3 +4...
    public static ArrayList<Integer> nSum(int n) {
        ArrayList<Integer> sequence = new ArrayList<>();
        int k = 0, count = 0, i = 0;
        while(count <= n) {
            i += k++;
            sequence.add(i);
            count++;
        }
        return sequence;
    }

    //      i.e. 1 * 2 * 3 * 4 ... * (n - 1) * n.
    public static ArrayList<Integer> factorial(int n) {
        int fact = 1, count = 0;
        ArrayList<Integer> factorialSequence = new ArrayList<>();
        for(int i = 2; count <= n; i++) {
            factorialSequence.add(fact);
            fact *= i;
            count++;
        }
        return factorialSequence;
    }

    // fibonacci(n) returns the nth Fibonacci number. These are defined as:
    // f(0) = 0
    // f(1) = 1
    // f(n) = f(n-1) + f(n-2)
    // (so f(2) is also 1. The first 10 fibonacci numbers are:
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55.

    public static int fibonacci(int n) {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
}