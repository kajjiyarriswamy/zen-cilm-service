package com.zen.inventory.controller;

import com.zen.inventory.domain.InventoryItem;
import com.zen.inventory.domain.InventoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Inventory service is healthy");
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<InventoryItem> getInventoryStatus(@PathVariable String productCode) {
        InventoryItem item = inventoryRepository.findByProductCode(productCode);
        if (item != null) {
            return ResponseEntity.ok(item);
        }
        else {
            InventoryItem defaultItem = new InventoryItem();
            defaultItem.setStatus("Available");
            defaultItem.setStock(100);
            defaultItem.setProductCode(productCode);
            defaultItem.setName("Laptops");
            return ResponseEntity.ok(defaultItem);
        }
    }

    @GetMapping("/info")
    public ResponseEntity<String> info() {
        return ResponseEntity.ok("Inventory service is ready for stock checks");
    }
}
