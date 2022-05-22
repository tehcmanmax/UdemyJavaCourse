package com.practice;

public class Main {

    public static void main(String[] args) {

        Person person = new Person();
        person.setAge(-6);
        System.out.println(person.isTeen());
        System.out.println("age is "+person.getAge());

    }
}
