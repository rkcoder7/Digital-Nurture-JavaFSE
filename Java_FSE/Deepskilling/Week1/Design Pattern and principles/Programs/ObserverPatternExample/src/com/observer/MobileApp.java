package com.observer;

public class MobileApp implements Observer {

    private String userName;

    public MobileApp(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println(
                userName +
                " received update on Mobile App: Stock Price = "
                + stockPrice);
    }
}