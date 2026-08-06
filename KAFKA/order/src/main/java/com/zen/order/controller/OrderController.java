package com.zen.order.controller;

import com.zen.order.domain.OrderDto;
import com.zen.order.domain.OrderEntity;
import com.zen.order.service.ExternalServiceDemoService;
import com.zen.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    
    private final ExternalServiceDemoService externalServiceDemoService;

    public OrderController(OrderService orderService,ExternalServiceDemoService externalServiceDemoService) {
        this.orderService = orderService;
        this.externalServiceDemoService=externalServiceDemoService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createOrder(
            @RequestParam String customerId,
            @RequestParam String productCode,
            @RequestParam Integer quantity,
            @RequestParam Double amount) {
        OrderEntity order = orderService.createOrder(customerId, productCode, quantity, amount);
        return ResponseEntity.ok(Map.of(
                "orderId", order.getId(),
                "status", order.getStatus(),
                "message", "Order created and event published to Kafka"
        ));
    }
    
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable String orderId) {
        return ResponseEntity.ok(externalServiceDemoService.demoRestTemplate(orderId));
    }

    @GetMapping("/info")
    public ResponseEntity<String> info() {
        return ResponseEntity.ok("Order service is routing to inventory and payment via HTTP calls");
    }
}
