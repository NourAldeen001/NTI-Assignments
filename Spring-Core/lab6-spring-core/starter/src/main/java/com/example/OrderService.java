package com.example;

public class OrderService {

    // TODO: constructor-inject a PaymentService
    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder(double amount) {
        // TODO: print "Placing order for " + amount
        System.out.println("Placing order for " + amount);
        // TODO: call paymentService.pay(amount)
        paymentService.pay(amount);
    }
}
