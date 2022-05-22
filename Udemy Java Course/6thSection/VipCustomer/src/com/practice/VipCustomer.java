package com.practice;

public class VipCustomer {
    private String name;
    private int creditLimit;
    private String email;


    public VipCustomer(){
        this("Unknown", 0, "error");
        System.out.println("empty constructor called");
    }

    public VipCustomer(String name, String email) {
        this(name,3000, email);
        System.out.println("2nd constructor called");

    }

    public VipCustomer(String name, int creditLimit, String email) {
        System.out.println("main constructor called");
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
}
