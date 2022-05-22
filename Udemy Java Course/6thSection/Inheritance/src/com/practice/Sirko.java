package com.practice;

public class Sirko extends Cat {
    private String woolColor;
    private String catOwnerName;
    private String eyesColor;


    public Sirko( String woolColor, String catOwnerName, String eyesColor) {
        super("British Shorthair", 2, 2);
        this.woolColor = woolColor;
        this.catOwnerName = catOwnerName;
        this.eyesColor = eyesColor;
    }
    public void shit(){
        System.out.println("Sirko is shitting instead of meowing");
    }

    @Override
    public void meow() {
        shit();
    }

    public String getWoolColor() {
        return woolColor;
    }

    public String getEyesColor() {
        return eyesColor;
    }

    public String getCatOwnerName() {
        return catOwnerName;
    }
}
