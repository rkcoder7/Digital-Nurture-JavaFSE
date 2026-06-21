package com.observer;

public class ObserverPatternTest {

    public static void main(String[] args) {

        StockMarket stockMarket =new StockMarket();

        Observer investor1 =new MobileApp("John");

        Observer investor2 =new WebApp("David");

        stockMarket.registerObserver(investor1);
        stockMarket.registerObserver(investor2);

        stockMarket.setStockPrice(1500.50);

        stockMarket.setStockPrice(1750.75);
    }
}