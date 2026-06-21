package com.decorator;

public class DecoratorPatternTest {

    public static void main(String[] args) {

        Notifier notifier =
                new SMSNotifier(
                        new EmailNotifier(
                                new BasicNotifier()));

        notifier.send();
    }
}