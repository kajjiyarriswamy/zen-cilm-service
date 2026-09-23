package com.zen.order.service;

public record OrderResponse(
        Long orderId,
        String customerId,
        String productCode,
        Integer quantity,
        Double amount,
        String status,
        String productName
) {
}
