package com.zenbank.cilm.controller;

import com.zenbank.cilm.dto.CustomerDetailsResponseDto;
import com.zenbank.cilm.service.CustomerService;
import com.zenbank.cilm.utility.ApiResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerDetailsController {

    private final CustomerService customerService;

    public CustomerDetailsController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Map<String, Object>> getCustomerDetails(@PathVariable String customerId) {
        try {
            CustomerDetailsResponseDto response = customerService.getCustomerDetails(customerId);
            return ResponseEntity.ok(ApiResponseUtil.success(response));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponseUtil.error(e.getMessage()));
        }
    }
}