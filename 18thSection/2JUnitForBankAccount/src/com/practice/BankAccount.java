package com.practice;

public class BankAccount {
    private String firstName;
    private String lastName;
    /*
     * An enum is a special "class" that represents a
     *  group of constants (unchangeable variables, like final variables).
        You can have an enum outside/inside a class
    * */

    enum Location {
        ATM,
        BRANCH
    }

    private double balance;

    public BankAccount(String firstName, String lastName, double balance){
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public double deposit(double amount){
        return this.balance += amount;
    }

    //Checking the proper amount with an enum
    public double withdraw_checkLocation(double amount, Location withdrawingLocation){
        if(withdrawingLocation == Location.ATM && amount >= 500)
            throw new IllegalArgumentException("Withdrawal amount exceeds the limit. You can withdraw this amount at a branch");

        return this.balance -= amount;
    }

    public double getBalance(){
        return balance;
    }

}
