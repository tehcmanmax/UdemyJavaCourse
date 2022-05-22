package com.practice;

public class Cat extends Animal{
    private String bride;
    private int legs;
    private int eyes;
    private int ears;


    public Cat() {
        this("Street Cat", 1, 2);
    }
    public Cat(String bride, int eyes, int ears) {
        super("Cat",1, 6);
    }
    public void meow(){
        System.out.println("Cat is meowing");
    }

    @Override
    public void sleep() {
        meow();
//        super.sleep(); it will get the sleep from the super class and not app;y the overide convept
    }
}
