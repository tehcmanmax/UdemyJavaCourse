package com.practice;

public abstract class Player {
    private String name;
    private int jerseyNumber;

    public Player(String name, int jerseyNumber) {
        this.name = name;
        this.jerseyNumber = jerseyNumber;
    }

    public String getName() {
        return name;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    @Override
    public String toString() {
        return "Player " + "name: '" + name + '\'' + ", jerseyNumber=" + jerseyNumber;
    }
}