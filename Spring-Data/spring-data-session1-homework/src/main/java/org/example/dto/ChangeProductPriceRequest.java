package org.example.dto;

import java.math.BigDecimal;

public record ChangeProductPriceRequest(Long productId, BigDecimal newPrice) {
}
