package com.strategy;

public class StrategyPatternTest {

    public static void main(String[] args) {

        PaymentContext context =
                new PaymentContext(
                        new CreditCardPayment());

        context.makePayment(5000);

        context.setStrategy(
                new PayPalPayment());

        context.makePayment(3000);

        context.setStrategy(
                new UpiPayment());

        context.makePayment(1500);
    }
}