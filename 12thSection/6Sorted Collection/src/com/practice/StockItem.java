package com.practice;

public class StockItem implements Comparable<StockItem> {
    private String itemName;
    private double itemPrice;
    private int quantityStock;

    public StockItem(String itemName, double itemPrice){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantityStock = 0;
    }

    public StockItem(String itemName, double itemPrice, int quantityStock){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantityStock = quantityStock;
    }

    public String getItemName(){
        return itemName;
    }

    public double getItemPrice(){
        return itemPrice;
    }

    public int getQuantityStock(){
        return quantityStock;
    }

    public void setItemPrice(double itemPrice){
        if(this.itemPrice + itemPrice >= 0)
            this.itemPrice = itemPrice;
        else
            System.out.println("Price of the item is less than 0");
    }

    public void setQuantityStock(int quantityStock){
        if(this.quantityStock + quantityStock >= 0)
            this.quantityStock = quantityStock;
        else
            System.out.println("Quantity of the item is less than 0");
    }

    @Override
    public int hashCode(){
        return super.hashCode() + 23;
    }

    @Override
    public boolean equals(Object obj){ //equals() method of Object class
        if(this == obj) //reference values are the same one pointer
            return true;

        if((obj == null) || (getClass() != obj.getClass())) //if we have the null or classes do not match
            return false;

        String passedObjectName = ((StockItem) obj).getItemName(); //casting and getting the passed object string name
        return this.itemName.equals(passedObjectName); //String equals() method; totally different implementation, thus, I can call it
    }

    @Override
    public int compareTo(StockItem o){ //overrides the method from the Comparable interface
        System.out.println("Using .compareTo() method");
        if(this == o)
            return 0;
        if(o != null)
            return this.itemName.compareTo(o.getItemName()); // calls method from the String class
        throw new NullPointerException(); //because I cannot compare something to nothing (null)
    }
}
