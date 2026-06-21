package com.adapter;

public class AdapterPatternTest {

    public static void main(String[] args) {

        PayPalGateway gateway = new PayPalGateway();

        PaymentProcessor processor =
                new PayPalAdapter(gateway);

        processor.processPayment(5000);
    }
}