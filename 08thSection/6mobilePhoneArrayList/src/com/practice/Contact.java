package com.practice;
//this class is a blueprint for myContacs ArrayList from the class MobilePhone

public class Contact {
    private String name = new String(); //redundant. yet, leave it as it is. It is an exemplary what is going on under Java's hood
    private String phoneNumber = new String();

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    static public Contact createContact(String personName, String phoneNumber) {
        return new Contact(personName, phoneNumber); //initiating a new instance
    }
}
