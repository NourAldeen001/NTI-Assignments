package com.example.tasktracker.exception;

public class MaxLimitExceededException extends RuntimeException {
    public MaxLimitExceededException(String message) {
        super(message);
    }
}
