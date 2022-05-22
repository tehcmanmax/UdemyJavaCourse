package com.practice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BankAccountTestParameterized {
    private BankAccount bankAccount;

    private final double expected;
    private final double actual;


    @Before
    public void setUp(){
        bankAccount = new BankAccount("Max", "D", 1000);
        System.out.println("Running a test...");
    }

    public BankAccountTestParameterized(double expected, double actual){
        this.expected = expected;
        this.actual = actual;
    }

    //ERROR
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]  { //making 2D array of the fields and wrapping them to the object
                {1500, 500},
                {1874.23, 874.23},
                {2331, 1331},
        });
    }

    @Test
    public void deposit(){
        assertEquals(expected, bankAccount.deposit(actual), 0);
    }
}