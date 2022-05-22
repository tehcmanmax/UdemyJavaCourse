//problem from Hackerrank
/*
Generic methods are a very efficient way to handle multiple datatypes using a single method.
This problem will test your knowledge on Java Generic methods.

Let's say you have an integer array and a string array. You have to write a single method printArray
that can print all the elements of both arrays. The method should be able to accept both integer arrays or string arrays.

You are given code in the editor. Complete the code so that it prints the following lines:

1
2
3
Hello
World

Do not use method overloading because your answer will not be accepted.
*/
// Possible inefficient solution would be using method overloading from the extended class

package com.practice;
import java.lang.reflect.Method;

class Printer<T> { //making a generic class type
    public void printArray(T[] t) { //printing out any data type because of the declared generic data type T[] (any array)
        for(T e : t) {
            System.out.println(e);
        }
    }
}

//alternative solution not using generics
class Printer2{
    public void printArray(Object[] array) {
        for (Object obj : array) {
            System.out.println(obj);
        }
    }
}



public class Solution {
//Raw use of parameterized class 'Printer'
//Unchecked call to 'printArray(T[])' as a member of raw type 'com.practice.Printer'
//compiler warns if it cannot tell whether a statement or expression is type safe;
// because it cannot be determined what type of elements are allowed

//when compiler expects generic data type and I do not use it, it will throw a warning "raw type ..."
    public static void main(String[] args) {
        Printer myPrinter = new Printer();
        Printer2 myPrinter2 = new Printer2();

        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        String[] gibberish = {"Apple, mom, mexican"};
        myPrinter2.printArray(gibberish);
        for(Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();
            if(name.equals("printArray"))
                count++;
        }

        if(count > 1) System.out.println("Method overloading is not allowed!");
    }
}