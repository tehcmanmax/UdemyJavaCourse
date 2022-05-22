package com.practice;

public class Account {
    private int accNumber;
    private double balance;
    private String name;
    private String email;
    private int phoneNumber;

    public Account (){
        this(3232,223); //instructor iside instructor. it will go to the  thisrd cinstructor
        System.out.println("empty constructor is called");
    }
    public Account(int accNumber,double balance,String name,String email,int phoneNumber){
        System.out.println("calling the biffest constructor");
        this.accNumber = accNumber;
        this.balance = balance;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public Account(int accNumber, double balance){
        System.out.println("calling another construcr with 2 parameteres");
        this.accNumber = accNumber;
        this.balance = balance;

        System.out.println("accnumber "+accNumber+" balance "+balance);
    }

//setters
/*

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//Getters
    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }
*/

//additional methods
    public void deposit(double x){
        balance += x;
        System.out.println("successfully added "+x+" to your bank account");
    }

    public double withdraw(double x){
        if (balance - x < 0){
            System.out.println("insufficient amount on your bank account");
            return 1;
        }
        balance -= x;
        return x;
    }

}
