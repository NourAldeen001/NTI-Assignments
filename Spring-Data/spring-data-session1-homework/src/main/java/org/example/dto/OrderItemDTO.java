package org.example.dto;

import java.math.BigDecimal;

public record OrderItemDTO(
        String productName,
        int quantity,
        BigDecimal unitPrice
) {
}
