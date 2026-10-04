package org.example.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long orderId) {
        super("order not found with id: " + orderId);
    }
}
