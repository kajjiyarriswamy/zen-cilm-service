package com.zen.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventoryClient", url = "${services.inventory.base-url}")
public interface InventoryClient {

    @GetMapping("/inventory/health")
    String health();

    @GetMapping("/inventory/{productCode}")
    String getInventoryStatus(@PathVariable("productCode") String productCode);
}
