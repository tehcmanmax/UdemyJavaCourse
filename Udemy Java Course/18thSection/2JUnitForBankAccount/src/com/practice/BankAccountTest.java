package com.practice;

//libraries

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BankAccountTest {

    @org.junit.Test
    public void deposit(){
        double amountAfterDeposit = new BankAccount("Max", "D", 1000) {}.deposit(200);
        assertEquals("deposit() does not work properly", 1200, amountAfterDeposit, 0);
    }

    @org.junit.Test
    public void withdraw_getBalance(){
        BankAccount bankAccount = new BankAccount("Max", "D", 1000);
        bankAccount.withdraw_checkLocation(200, BankAccount.Location.BRANCH);
        assertEquals("Some problem here", 800, bankAccount.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance(){
        assertEquals(500, new BankAccount("", "", 500).getBalance(), 0);
    }

    @Test
    public void dummyTest(){
        assertEquals("Not equal", 23, 23);
        assertNull(null);
    }
}