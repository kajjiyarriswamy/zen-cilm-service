package com.zen.order.service;

import com.zen.order.client.InventoryClient;
import com.zen.order.client.PaymentClient;
import com.zen.order.domain.InventoryDetails;
import com.zen.order.domain.OrderEntity;
import com.zen.order.domain.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExternalServiceDemoServiceTest {

    @Test
    void getOrderWithProductNameUsingRestTemplateReturnsEnrichedOrder() {
        OrderRepository orderRepository = mock(OrderRepository.class);
        RestTemplate restTemplate = mock(RestTemplate.class);
        WebClient.Builder webClientBuilder = mock(WebClient.Builder.class);
        PaymentClient paymentClient = mock(PaymentClient.class);
        InventoryClient inventoryClient = mock(InventoryClient.class);

        OrderEntity order = new OrderEntity("C100", "P100", 2, 120.0, "CREATED");
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        InventoryDetails inventoryDetails = new InventoryDetails();
        inventoryDetails.setProductCode("P100");
        inventoryDetails.setProductName("Laptop");
        when(restTemplate.getForObject(anyString(), eq(InventoryDetails.class))).thenReturn(inventoryDetails);

        ExternalServiceDemoService service = new ExternalServiceDemoService(
                restTemplate,
                webClientBuilder,
                paymentClient,
                inventoryClient,
                orderRepository
        );

        OrderResponse response = service.getOrderWithProductNameUsingRestTemplate(1L);

        assertEquals("Laptop", response.productName());
        assertEquals("P100", response.productCode());
    }
}
