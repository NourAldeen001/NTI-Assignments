package org.example.exception;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(Long id) {
        super("You order quantity exceed stock from product with id: " + id );
    }
}
