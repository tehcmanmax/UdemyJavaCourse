package com.practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final Map<StockItem, Integer> inBasket;

    public Basket(){
        this.inBasket = new HashMap<>();
    }

    public int addToBasket(StockItem item, int amount){
        if(item != null && amount > 0){
            int numberItems = this.inBasket.getOrDefault(item, 0);
            this.inBasket.put(item, numberItems + amount);
            return numberItems + amount;
        }
        return 0;
    }

    public Map<StockItem, Integer> getImmutableInBasket(){
        return Collections.unmodifiableMap(this.inBasket);
    }

    @Override
    public String toString(){
        int amountOfItems = 0;
        double totalItemPrice = 0.0, totalCostOfItems = 0.0;
        for(StockItem item : this.inBasket.keySet()){
            System.out.println("Item " + item.getItemName() + ":");

            amountOfItems += item.getQuantityStock();
            System.out.println(amountOfItems + " in the basket");

            totalItemPrice = item.getItemPrice() * item.getQuantityStock();
            System.out.println(totalItemPrice + " total price of this item type");

            totalCostOfItems += totalItemPrice;
        }
        return "You have spent " + totalCostOfItems + " during this shopping";
    }
}
