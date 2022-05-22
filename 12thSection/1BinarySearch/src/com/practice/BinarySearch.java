package com.practice;

import java.util.*;

public class BinarySearch {
    private final List<Integer> numbers = new LinkedList<>();
    private final int amountDigits;

    //should be final because I do not modify the type Scanner, but only the value it holds, and that's ok
    private final Scanner entry = new Scanner(System.in);

    public BinarySearch(int amountDigits) {
        this.amountDigits = amountDigits;

        System.out.println("Please, fill the data type from the collection framework");
        for(int i = 0; i < amountDigits; i++) {
            System.out.print(i + 1 + " entry is -> ");

            numbers.add(entry.nextInt());
        }
    }

    public void binarySearch() {
        LinkedList<Integer> temp = new LinkedList<>(this.numbers); // object copy
        //        List<Integer> temp = this.numbers; // reference copy; points to the original list (store references to their data (objects))

        Collections.sort(temp); // binary search requires the sorted data
        System.out.print("Enter the a number which you want to check whether it is present ");

        int index = Collections.binarySearch(temp, this.entry.nextInt());
        if(index >= 0) {
            System.out.println("That number " + temp.get(index) + " is present in the list ");
        } else
            System.out.println("Could not find the element");
    }

    @Override
    public String toString() {
        return "BinarySearch{" + "numbers=" + numbers + ", amountDigits=" + amountDigits + '}';
    }
}
