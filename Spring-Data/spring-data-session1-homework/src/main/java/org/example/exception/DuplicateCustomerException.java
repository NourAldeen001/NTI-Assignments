package org.example.exception;

public class DuplicateCustomerException extends RuntimeException {
    public DuplicateCustomerException(String email) {
        super(email + " This email already exists");
    }
}
