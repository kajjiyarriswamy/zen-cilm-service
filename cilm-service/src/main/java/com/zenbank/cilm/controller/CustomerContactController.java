package com.zenbank.cilm.controller;

import com.zenbank.cilm.dto.CustomerContactRequestDto;
import com.zenbank.cilm.dto.CustomerContactResponseDto;
import com.zenbank.cilm.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerContactController {

    private final CustomerService customerService;

    public CustomerContactController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/{customerId}/contacts")
    public ResponseEntity<?> addContact(@PathVariable String customerId,
                                        @Valid @RequestBody CustomerContactRequestDto requestDto) {
        try {
            CustomerContactResponseDto response = customerService.addContact(customerId, requestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new CustomerContactResponseDto("FAILED", e.getMessage(), null, null)
            );
        }
    }
}