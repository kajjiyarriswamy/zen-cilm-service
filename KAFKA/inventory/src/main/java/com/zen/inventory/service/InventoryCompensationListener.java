package com.zen.inventory.service;

import com.zen.inventory.domain.InventoryItem;
import com.zen.inventory.domain.InventoryRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryCompensationListener {

    private final InventoryRepository inventoryRepository;

    public InventoryCompensationListener(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @KafkaListener(topics = "order-compensation-topic", groupId = "inventory-service-group")
    public void handleCompensation(String message) {
        System.out.println("Inventory compensation received: " + message);
        InventoryItem item = inventoryRepository.findByProductCode("LAPTOP");
        if (item != null) {
            item.setStatus("COMPENSATED");
            inventoryRepository.save(item);
        }
    }
}
