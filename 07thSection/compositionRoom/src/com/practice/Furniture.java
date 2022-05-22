package com.practice;

public class Furniture {
    private String primaryColor;
    private String material;
    private boolean isNew;

    public Furniture(String primaryColor, String material, boolean isNew) {
        this.primaryColor = primaryColor;
        this.material = material;
        this.isNew = isNew;
    }


    public void movingFurn(String object){
        System.out.println("Moving "+object+" furniture around");
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public String getMaterial() {
        return material;
    }

    public boolean isNew() {
        return isNew;
    }
}
