package com.practice;

import java.util.LinkedList;
import java.util.List;

public class Monster implements ISaveable {
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }

    @Override
    public List<String> save() {
        List<String> listOfFields = new LinkedList<>();
        String[] tokens = toString().split("[{}]");

        listOfFields.add(0, tokens[0] + ":");
        for(int i = 1; i < tokens.length; i++) {
            listOfFields.add(i, tokens[i]);
        }
        return listOfFields;
    }

    @Override
    public void print(List<String> list) {
        if(list != null && list.size() > 0) {
            for(String s : list) {
                System.out.println(s);
            }
        }
    }
}
