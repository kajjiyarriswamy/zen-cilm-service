package com.zen.order.controller;

import com.zen.order.domain.OrderEntity;
import com.zen.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(
            @RequestParam String customerId,
            @RequestParam String productCode,
            @RequestParam Integer quantity,
            @RequestParam Double amount) {
        return ResponseEntity.ok(orderService.createOrder(customerId, productCode, quantity, amount));
    }
}
