package com.practice;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UtilitiesTestParameterized {
    private Utilities utilities;

    private String expected;
    private String actual;

    public UtilitiesTestParameterized(String expected, String actual){
        this.expected = expected;
        this.actual = actual;
    }

    @org.junit.Before
    public void setUp() throws Exception{
        utilities = new Utilities();
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{ //because an array is a one dimensional!
                {"asas", "asasssss"},
                {"Runer", "Runner"},
                {"Runer", "Runner"},
                {null, null},
                {"a", "a"}
        });
    }

    @org.junit.Test
    public void removePairs(){
        assertEquals(expected, utilities.removePairs(actual));
    }
}