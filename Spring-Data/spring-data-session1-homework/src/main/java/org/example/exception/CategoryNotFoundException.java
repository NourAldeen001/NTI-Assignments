package org.example.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String name) {
        super("category not found with name: " + name);
    }

    public CategoryNotFoundException(Long id) {
        super("category not found with id: " + id);
    }
}
