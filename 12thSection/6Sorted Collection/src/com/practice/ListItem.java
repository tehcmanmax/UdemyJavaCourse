package com.practice;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ListItem {
    private final Map<String, StockItem> stockItem;

    public ListItem(){
        stockItem = new LinkedHashMap<>();
    }

    public StockItem get(String key){ //used by the instantiated the object, not from the current class!
        return this.stockItem.get(key);

    }

    public Map<String, StockItem> getImmutableList(){
        return Collections.unmodifiableMap(stockItem);
    }

    public int addStock(StockItem item){
        if(item != null){
            StockItem fromTheList = this.stockItem.get(item.getItemName());
            if(fromTheList != null){
                fromTheList.setQuantityStock(item.getQuantityStock());
            }
            this.stockItem.put(item.getItemName(), item);
        }
        if(item == null) // in case if Calling the instance method of a null object.
            throw new NullPointerException();
        return item.getQuantityStock();
    }

    public int sellStock(String item, int quantity){
        StockItem fromTheList = this.stockItem.get(item);

        if((fromTheList != null) && ((fromTheList.getQuantityStock() + quantity) >= 0 && (quantity > 0))){
            fromTheList.setQuantityStock(-quantity);
            this.stockItem.put(fromTheList.getItemName(), fromTheList);
        }
        if(fromTheList == null) // in case if Calling the instance method of a null object.
            throw new NullPointerException();
        return fromTheList.getQuantityStock();
    }

    @Override
    public String toString(){
        int totalAmountOfAllItems = 0;
        double totalCostOfItem, priceOfAllItems = 0.0;

        for(Map.Entry<String, StockItem> entry : this.stockItem.entrySet()){ // don't forget to add entrySet() to the HashMap
            System.out.println("Item " + entry.getValue().getItemName() + ":");

            totalAmountOfAllItems += entry.getValue().getQuantityStock();
            System.out.println(totalAmountOfAllItems + " available in stock");

            totalCostOfItem = entry.getValue().getItemPrice() * entry.getValue().getQuantityStock();
            System.out.println(totalCostOfItem + " total price of this item type");

            priceOfAllItems += totalAmountOfAllItems;
        }
        return "Finished querying. Total stock value is " + priceOfAllItems;
    }
    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String, StockItem> item : stockItem.entrySet()) {
            prices.put(item.getKey(), item.getValue().getItemPrice());
        }
        return Collections.unmodifiableMap(prices);
    }
}
