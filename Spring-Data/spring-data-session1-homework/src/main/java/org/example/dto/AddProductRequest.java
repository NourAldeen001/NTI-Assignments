package org.example.dto;

import org.example.model.Category;

import java.math.BigDecimal;

public record AddProductRequest(String sku, String name,
                                BigDecimal price, int stock, String categoryName) {
}
