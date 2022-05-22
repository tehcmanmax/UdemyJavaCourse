package com.practice;
/* TASKS
 * 1. Recap the equal()
 * */

import java.util.Map;

/* IMPLEMENT
Map<String, StockItem> list; +
stockitem get from the list +
Items collections.immutable list +
int addStock; if passed not null get from list; check whether null if not -> add; add to the list either way +
int sellStock(String item, int quantity) get from the list(passedValue); if not null and sum is > 0 and quan. > 0 +
toString iterate through the list; sum: totalAmoIt, totalCostIt, totalCostofAll +

basket class +
Basket constructor +
addToBasket m +
Items immutable map +
toString calc amount of taken items and its total cost, total cost of all items in bask +
name f +
list f +

fill the stock from the main class
*/
public class Main {
    private final static ListItem stock = new ListItem(); // to access the market stock

    public static void main(String[] args){

        StockItem temp = new StockItem("Milk", 1.3, 50);
        stock.addStock(temp);

        temp = new StockItem("Water", 0.5, 200);
        stock.addStock(temp);

        temp = new StockItem("White bread", 1, 120);
        stock.addStock(temp);

        temp = new StockItem("Chips", 2.5, 1000);
        stock.addStock(temp);

        temp = new StockItem("Chicken breast", 15, 100);
        stock.addStock(temp);


        System.out.println(stock.toString());


        Basket timsBasket = new Basket();
        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        if(sellItem(timsBasket, "car", 1) != 1){
            System.out.println("There are no more cars in stock");
        }

        sellItem(timsBasket, "spanner", 5);
        System.out.println(timsBasket);

        sellItem(timsBasket, "juice", 4);
        sellItem(timsBasket, "cup", 12);
        sellItem(timsBasket, "bread", 1);
        System.out.println(timsBasket);

        System.out.println(stock);

        System.out.println(stock);
        for(Map.Entry<String, Double> price : stock.PriceList().entrySet()){
            System.out.println(price.getKey() + " costs " + price.getValue());
        }


    }

    public static int sellItem(Basket basket, String item, int quantity){
        //retrieve the item from stock list
        StockItem stockItem = stock.get(item);
        if(stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stock.sellStock(item, quantity) != 0){
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}


