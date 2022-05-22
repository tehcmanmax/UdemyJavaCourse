package com.practice;

import org.junit.*;

import static org.junit.Assert.*;


public class BankAccountBeforeAnnotationsTest {
    private BankAccount bankAccount;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("About to run tests...");

    }

    @Before
    public void setUp(){
        bankAccount = new BankAccount("Max", "D", 1500);
    }

    @Test
    public void deposit(){
        assertEquals(2000, bankAccount.deposit(500), 0);
        System.out.println("deposit() -- checked!");
    }

    @Test(expected = IllegalArgumentException.class) //passes because I said so after the annotation
    public void withdraw_checkLocation_expected(){
        assertEquals(500, bankAccount.withdraw_checkLocation(1000, BankAccount.Location.ATM), 0);
        System.out.println("withdraw_checkLocation() -- checked!");
        fail();
    }

    @Test
    public void withdraw_checkLocation_IllegalArg(){ //expects to fail (exception)
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw_checkLocation(1000, BankAccount.Location.ATM);
            assertEquals(500, bankAccount.withdraw_checkLocation(1000, BankAccount.Location.BRANCH), 0);
            fail();
        }); //Expects Runnable
    }

    @Test
    public void balance(){
        assertNotEquals(0, bankAccount.getBalance());
        System.out.println("balance() -- checked!");
    }

    @After
    public void tearDown(){
        bankAccount = null;
        System.out.println("Removed the pointer to the bankAccount object!");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("Tests are finished.");
    }
}