package com.zen.order.service;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.zen.order.domain.OrderEntity;
import com.zen.order.domain.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderService(OrderRepository orderRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.orderRepository = orderRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public OrderEntity createOrder(String customerId, String productCode, Integer quantity, Double amount) {
        OrderEntity order = orderRepository.save(new OrderEntity(customerId, productCode, quantity, amount, "CREATED"));

        String event = "{" +
                "\"orderId\":" + order.getId() + "," +
                "\"customerId\":\"" + customerId + "\"," +
                "\"productCode\":\"" + productCode + "\"," +
                "\"quantity\":" + quantity + "," +
                "\"amount\":" + amount + "}";

        kafkaTemplate.send("order-created-topic", event);
        return order;
    }

    public void markFailed(Long orderId) {
        OrderEntity order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus("FAILED");
        orderRepository.save(order);
    }

    public void markCompensated(Long orderId) {
        OrderEntity order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus("COMPENSATED");
        orderRepository.save(order);
    }
}
