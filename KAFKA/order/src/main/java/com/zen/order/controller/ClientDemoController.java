package com.zen.order.controller;

import com.zen.order.service.ExternalServiceDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client-demo")
public class ClientDemoController {

    private final ExternalServiceDemoService externalServiceDemoService;

    public ClientDemoController(ExternalServiceDemoService externalServiceDemoService) {
        this.externalServiceDemoService = externalServiceDemoService;
    }

    @GetMapping("/rest-template")
    public String restTemplateDemo(@RequestParam String url) {
        return externalServiceDemoService.demoRestTemplate(url);
    }

    @GetMapping("/webclient")
    public String webClientDemo(@RequestParam String url) {
        return externalServiceDemoService.demoWebClient(url);
    }

    @GetMapping("/feign/payment")
    public String feignPaymentDemo() {
        return externalServiceDemoService.demoFeignPayment();
    }

    @GetMapping("/feign/inventory")
    public String feignInventoryDemo() {
        return externalServiceDemoService.demoFeignInventory();
    }
}
