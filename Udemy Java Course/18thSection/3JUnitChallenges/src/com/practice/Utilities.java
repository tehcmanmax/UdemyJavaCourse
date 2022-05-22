package com.practice;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class Utilities {

    // Returns a char array containing every nth char. When
    // sourceArray.length < n, returns sourceArray
    public char[] everyNthChar(char[] sourceArray, int n){

        if(sourceArray == null || n > sourceArray.length){
            return sourceArray;
        }
        //hello-- 5; every 2nd
        int returnedLength = sourceArray.length / n;
        char[] result = new char[returnedLength];
        int index = 0;

        for(int i = n - 1; i < sourceArray.length; i += n){
            result[index++] = sourceArray[i];
        }

        return result;
    }

    // Removes pairs of the same character that are next
    // to each other, by removing one occurrence of the character.
    // "ABBCDEEF" -> "ABCDEF"
    // "ABCBDEEF" -> "ABCBDEF" (the two B's aren't next to each other, so they
    // aren't removed)
    public String removePairs(String source){

/* EASIER WAY
        CharacterIterator iterator = new StringCharacterIterator(source);

        while (iterator.current() != CharacterIterator.DONE)
        {
            char currentChar = iterator.current(); // getting current char
            char nextChar = iterator.next(); // getting next char and updating current's position
            if (currentChar != nextChar)
                sb.append(currentChar);
        }
    }*/

        // If length is less than 2, there won't be any pairs
        if(source == null || source.length() < 2){
            return source;
        }

        StringBuilder sb = new StringBuilder();
        char[] charArray = source.toCharArray();

        for(int i = 0; i < (charArray.length - 1); i++){
            if(charArray[i] != charArray[i + 1]){
                sb.append(charArray[i]);
            }
        }
        //last characcter is safe (not a pair)
        sb.append(charArray[charArray.length - 1]);

        return sb.toString();
    }

    // performs a conversion based on some internal
    // business rule
    public int converter(int a, int b){
        if(b == 0)
            throw new ArithmeticException();
        return (a / b) + (a * 30) - 2;
    }

    public String nullIfOddLength(String source){
        if(source.length() % 2 == 0){
            return source;
        }

        return null;
    }
}
