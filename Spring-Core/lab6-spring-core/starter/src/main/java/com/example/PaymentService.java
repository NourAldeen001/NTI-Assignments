package com.example;

// Exercise 6.8 — Capstone: Three-Layer Wiring
// OrderService -> PaymentService -> Notifier
public class PaymentService {

    // TODO: constructor-inject a Notifier
    private final Notifier notifier;

    public PaymentService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void pay(double amount) {
        // TODO: print "Paying " + amount
        System.out.println("Paying " + amount);
        // TODO: call notifier.send("Payment of " + amount + " completed")
        notifier.send("Payment of " + amount + " completed");
    }
}
