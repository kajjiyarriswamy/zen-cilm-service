package com.zenbank.cilm.controller;

import com.zenbank.cilm.dto.CustomerResponseDto;
import com.zenbank.cilm.dto.CustomerStatusUpdateRequest;
import com.zenbank.cilm.dto.CustomerUpdateRequestDto;
import com.zenbank.cilm.service.CustomerService;
import com.zenbank.cilm.utility.ApiResponseUtil;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createCustomer(@Valid @RequestBody CustomerUpdateRequestDto requestDto) {
        CustomerResponseDto responseDto = customerService.createCustomer(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseUtil.success(responseDto));
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllCustomers() {
        List<CustomerResponseDto> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(ApiResponseUtil.success(customers));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id)
                .map(customer -> ResponseEntity.ok(ApiResponseUtil.success(customer)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponseUtil.error("Customer not found")));
    }
    
    @PutMapping("/{customerId}/status")
    public ResponseEntity<String> updateCustomerStatus(
            @PathVariable Long customerId,
            @RequestBody CustomerStatusUpdateRequest request) {

        customerService.updateCustomerStatus(customerId, request.getStatus());
        return ResponseEntity.ok("Customer status updated successfully");
    }
  
}
