package com.zen.order.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderCompensationListener {

    private final OrderService orderService;

    public OrderCompensationListener(OrderService orderService) {
        this.orderService = orderService;
    }

    @KafkaListener(topics = "order-compensation-topic", groupId = "order-service-group")
    public void handleCompensation(String message) {
        System.out.println("Compensation received: " + message);
        Long orderId = extractOrderId(message);
        if (orderId != null) {
            orderService.markFailed(orderId);
        }
    }

    private Long extractOrderId(String message) {
        try {
            String[] parts = message.split("\\\"");
            for (int i = 0; i < parts.length - 1; i++) {
                if (parts[i].contains("orderId")) {
                    return Long.parseLong(parts[i + 1]);
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }
}
