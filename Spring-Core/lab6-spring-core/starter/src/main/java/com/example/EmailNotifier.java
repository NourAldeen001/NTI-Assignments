package com.example;

public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        // TODO: print "Email sent: " + message
        System.out.println("Email sent: " + message);
    }
}
