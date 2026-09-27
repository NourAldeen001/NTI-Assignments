package com.example;

public class SmsNotifier implements Notifier {
    @Override
    public void send(String message) {
        // TODO: print "SMS sent: " + message
        System.out.println("SMS sent: " + message);
    }
}
