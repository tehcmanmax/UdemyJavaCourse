package com.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UtilitiesTest {

    private Utilities utilities;

    @BeforeEach
    void setUp(){
        this.utilities = new Utilities();
    }


    //Array is considered to be an object in Java. The reason behind this is that an array can be created using the 'new' keyword
    @Test
    public void everyNthChar(){
        assertEquals(Arrays.toString(new char[]{'e', 'l'}), Arrays.toString((utilities.everyNthChar(("hello".toCharArray()), 2))));
        //or easier
        assertArrayEquals(new char[]{'e', 'l'}, utilities.everyNthChar(("hello".toCharArray()), 2));
        assertArrayEquals("Centipedes".toCharArray(), utilities.everyNthChar("Centipedes".toCharArray(), 11));
        assertArrayEquals("Centipedes".toCharArray(), utilities.everyNthChar("Centipedes".toCharArray(), 123));

    }

    @Test
    public void removePairs(){
        assertEquals("acdefgd", utilities.removePairs("aacdefggdd"));
        assertEquals("fge", utilities.removePairs("ffggee"));
        assertEquals("qwerty", utilities.removePairs("qwerrrttttyy"));
        assertEquals("qwerty", utilities.removePairs("qwerrrttttyy"));
        assertEquals("", utilities.removePairs(""));
        assertNull(utilities.removePairs(null));
    }

    @Test
    public void converter(){
        assertThrows(ArithmeticException.class, () -> {
            utilities.converter(1, 0);
            System.out.println("ArithmeticException(\"divide by 0\")");
        });
        assertNotEquals(0, utilities.converter(1, 1));
        assertEquals(300, utilities.converter(10, 5));
    }

    @Test
    public void nullIfOddLength(){
        assertEquals("Summer", utilities.nullIfOddLength("Summer"));
        assertNotEquals("Summers", utilities.nullIfOddLength("Summers"));
        assertNull(utilities.nullIfOddLength("Array"));
        assertNotNull(utilities.nullIfOddLength("Even"));
    }
}