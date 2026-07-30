package com.zen.inventory.service;

import com.zen.inventory.domain.InventoryItem;
import com.zen.inventory.domain.InventoryRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InventoryConsumerService {

    private final InventoryRepository inventoryRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public InventoryConsumerService(InventoryRepository inventoryRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.inventoryRepository = inventoryRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "order-created-topic", groupId = "inventory-service-group")
    public void consume(String message) {
        System.out.println("Inventory received: " + message);

        InventoryItem item = inventoryRepository.findByProductCode("LAPTOP");
        if (item == null) {
            item = inventoryRepository.save(new InventoryItem("LAPTOP", 10, "AVAILABLE"));
        }

        if (item.getStock() >= 1) {
            item.setStock(item.getStock() - 1);
            item.setStatus("RESERVED");
            inventoryRepository.save(item);
            kafkaTemplate.send("inventory-processed-topic", message);
        } else {
            kafkaTemplate.send("payment-failed-topic", message);
        }
    }
}
