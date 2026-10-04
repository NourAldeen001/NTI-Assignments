package org.example.exception;

public class DuplicateProductException extends RuntimeException {
    public DuplicateProductException(String sku) {
        super("This product already exists with sku: " + sku);
    }
}
