package org.example.dto;

import org.example.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderSummaryDTO(
        String customerName,
        String customerEmail,
        Address shippingAddress,
        OrderStatus status,
        LocalDateTime orderedAt,
        BigDecimal amount,
        PaymentMethod method,
        LocalDateTime paidAt,
        List<OrderItemDTO> items
) { }


