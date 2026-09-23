package com.zen.order.service;

import com.zen.order.client.InventoryClient;
import com.zen.order.client.PaymentClient;
//import com.zen.order.domain.InventoryDetails;
import com.zen.order.domain.InventoryItem;
import com.zen.order.domain.OrderDto;
import com.zen.order.domain.OrderEntity;
import com.zen.order.domain.OrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ExternalServiceDemoService {

    private final RestTemplate restTemplate;
    private final WebClient webClient;
    private final PaymentClient paymentClient;
    private final InventoryClient inventoryClient;
    private final OrderRepository orderRepository;

    public ExternalServiceDemoService(RestTemplate restTemplate,
                                      WebClient.Builder webClientBuilder,
                                      PaymentClient paymentClient,
                                      InventoryClient inventoryClient,
                                      OrderRepository orderRepository) {
        this.restTemplate = restTemplate;
        this.webClient = webClientBuilder.build();
        this.paymentClient = paymentClient;
        this.inventoryClient = inventoryClient;
        this.orderRepository = orderRepository;
    }

    
    @CircuitBreaker(name = "inventoryService",
            fallbackMethod = "inventoryFallback")
    public  OrderDto demoRestTemplate(String orderId) {
    	ResponseEntity<InventoryItem> response =
    	        restTemplate.getForEntity(
    	                "http://localhost:8082/inventory/10012",
    	                InventoryItem.class);

    	InventoryItem inventory = response.getBody();

    	System.out.println(inventory.getName());
    	System.out.println(inventory.getStock());
    	System.out.println(inventory.getStatus());
    	OrderDto dto=new OrderDto();
    	dto.setDescription("Order for Laptop");
    	dto.setOrderId(orderId);
    	dto.setProductCode(inventory.getProductCode());
    	dto.setProductName(inventory.getName());
    	return dto;
        
    }
    
  
    
    @CircuitBreaker(name = "inventoryService",
            fallbackMethod = "inventoryFallback")
    public OrderDto demoRestTemplate1(String orderId) {

        ResponseEntity<InventoryItem> response =
                restTemplate.getForEntity(
                        "http://localhost:8082/inventory/10012",
                        InventoryItem.class);

        InventoryItem inventory = response.getBody();

        OrderDto dto = new OrderDto();
        dto.setOrderId(orderId);
        dto.setDescription("Order for Laptop");
        dto.setProductCode(inventory.getProductCode());
        dto.setProductName(inventory.getName());

        return dto;
    }
    
    public OrderDto inventoryFallback(String orderId, Exception ex) {

        OrderDto dto = new OrderDto();

        dto.setOrderId(orderId);
        dto.setDescription("Inventory Service Down");
        dto.setProductCode("NA");
        dto.setProductName("Product Unavailable");

        return dto;
    }

    public String demoWebClient(String serviceUrl) {
        return webClient.get()
                .uri(serviceUrl)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String demoFeignPayment() {
        return paymentClient.health();
    }

    public String demoFeignInventory() {
        return inventoryClient.health();
    }

//    public OrderResponse getOrderWithProductNameUsingRestTemplate(Long orderId) {
//        OrderEntity order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + orderId));
//
//        String inventoryUrl = "http://localhost:8083/inventory/" + order.getProductCode();
//        InventoryDetails inventoryDetails = restTemplate.getForObject(inventoryUrl, InventoryDetails.class);
//        String productName = inventoryDetails != null ? inventoryDetails.getProductName() : "UNKNOWN";
//
//        return new OrderResponse(
//                order.getId(),
//                order.getCustomerId(),
//                order.getProductCode(),
//                order.getQuantity(),
//                order.getAmount(),
//                order.getStatus(),
//                productName
//        );
//    }
//
//    public OrderResponse getOrderWithProductNameUsingWebClient(Long orderId) {
//        OrderEntity order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + orderId));
//
//        InventoryDetails inventoryDetails = webClient.get()
//                .uri("http://localhost:8083/inventory/" + order.getProductCode())
//                .retrieve()
//                .bodyToMono(InventoryDetails.class)
//                .block();
//
//        String productName = inventoryDetails != null ? inventoryDetails.getProductName() : "UNKNOWN";
//
//        return new OrderResponse(
//                order.getId(),
//                order.getCustomerId(),
//                order.getProductCode(),
//                order.getQuantity(),
//                order.getAmount(),
//                order.getStatus(),
//                productName
//        );
//    }
//
//    public OrderResponse getOrderWithProductNameUsingFeign(Long orderId) {
//        OrderEntity order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + orderId));
//
//        InventoryDetails inventoryDetails = inventoryClient.getInventoryDetails(order.getProductCode());
//        String productName = inventoryDetails != null ? inventoryDetails.getProductName() : "UNKNOWN";
//
//        return new OrderResponse(
//                order.getId(),
//                order.getCustomerId(),
//                order.getProductCode(),
//                order.getQuantity(),
//                order.getAmount(),
//                order.getStatus(),
//                productName
//        );
//    }
}
