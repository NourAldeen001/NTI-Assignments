package org.example.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long customerId) {
        super("customer not found with id: " + customerId);
    }
}
