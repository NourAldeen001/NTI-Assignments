package com.example.service;

public class InvalidEmployeeException extends RuntimeException {
    public InvalidEmployeeException(String message) {
        super(message);
    }
}
