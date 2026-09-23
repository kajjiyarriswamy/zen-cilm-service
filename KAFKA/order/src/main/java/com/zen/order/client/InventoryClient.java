package com.zen.order.client;

//import com.zen.order.domain.InventoryDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventoryClient", url = "${services.inventory.base-url}")
public interface InventoryClient {

    @GetMapping("/inventory/health")
    String health();
//
//    @GetMapping("/inventory/{productCode}")
//    InventoryDetails getInventoryDetails(@PathVariable("productCode") String productCode);
}
