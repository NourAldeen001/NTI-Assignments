package org.example.exception;

public class InvalidOrderStateException extends RuntimeException {
    public InvalidOrderStateException() {
        super("invalid order state");
    }
}
