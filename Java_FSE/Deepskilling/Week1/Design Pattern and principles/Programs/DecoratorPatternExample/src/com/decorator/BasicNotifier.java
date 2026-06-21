package com.decorator;

public class BasicNotifier implements Notifier {

    @Override
    public void send() {
        System.out.println("Sending Basic Notification");
    }
}