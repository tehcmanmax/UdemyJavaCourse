//copied by refactor -> copy
package com.practice;

public class Tesla extends Car{
    public Tesla(int cylinders, String name){
        super( cylinders,  name);
    }

    @Override
    public String startEngine() {
        return "Tesla start";
    }

    @Override
    public String accelerate() {
        return "Tesla faster";
    }

    @Override
    public String brake() {
        return "Tesla stop";
    }
}
