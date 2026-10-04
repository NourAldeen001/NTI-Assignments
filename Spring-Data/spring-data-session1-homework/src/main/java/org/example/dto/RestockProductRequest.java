package org.example.dto;

public record RestockProductRequest(Long productId, int quantity) {
}
