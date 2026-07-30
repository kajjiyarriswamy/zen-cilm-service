package com.zen.order.service;

import com.zen.order.client.InventoryClient;
import com.zen.order.client.PaymentClient;
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

    public ExternalServiceDemoService(RestTemplate restTemplate,
                                      WebClient.Builder webClientBuilder,
                                      PaymentClient paymentClient,
                                      InventoryClient inventoryClient) {
        this.restTemplate = restTemplate;
        this.webClient = webClientBuilder.build();
        this.paymentClient = paymentClient;
        this.inventoryClient = inventoryClient;
    }

    public String demoRestTemplate(String serviceUrl) {
        ResponseEntity<String> response = restTemplate.getForEntity(serviceUrl, String.class);
        return response.getBody();
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
}
