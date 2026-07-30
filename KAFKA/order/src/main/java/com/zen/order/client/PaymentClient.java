package com.zen.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "paymentClient", url = "${services.payment.base-url}")
public interface PaymentClient {

    @GetMapping("/payments/health")
    String health();

    @GetMapping("/payments/{orderId}")
    String getPaymentStatus(@PathVariable("orderId") Long orderId);
}
