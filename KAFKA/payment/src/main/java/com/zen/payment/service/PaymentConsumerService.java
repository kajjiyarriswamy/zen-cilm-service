package com.zen.payment.service;

import com.zen.payment.domain.PaymentRepository;
import com.zen.payment.domain.PaymentTransaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumerService {

    private final PaymentRepository paymentRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public PaymentConsumerService(PaymentRepository paymentRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.paymentRepository = paymentRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "inventory-processed-topic", groupId = "payment-service-group")
    public void consume(String message) {
        System.out.println("Payment received: " + message);

        PaymentTransaction transaction = new PaymentTransaction(1L, 100.0, "SUCCESS");
        paymentRepository.save(transaction);
        kafkaTemplate.send("payment-success-topic", message);
    }

    @KafkaListener(topics = "payment-failed-topic", groupId = "payment-service-group")
    public void handleFailure(String message) {
        System.out.println("Payment failure received: " + message);
        PaymentTransaction transaction = new PaymentTransaction(1L, 100.0, "FAILED");
        paymentRepository.save(transaction);
        kafkaTemplate.send("order-compensation-topic", message);
    }
}
