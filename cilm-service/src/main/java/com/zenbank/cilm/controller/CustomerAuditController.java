package com.zenbank.cilm.controller;

import com.zenbank.cilm.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerAuditController {

    private final CustomerService customerService;

    public CustomerAuditController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}/audit/search")
    public ResponseEntity<?> searchAudit(
            @PathVariable String customerId,
            @RequestParam(required = false) String action,
            @RequestParam(required = false) String performedBy,
            @RequestParam(required = false) String fromDate,
            @RequestParam(required = false) String toDate,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Map<String, Object> response = customerService.searchAudit(
                    customerId, action, performedBy, fromDate, toDate, page, size);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("status", "FAILED", "message", e.getMessage()));
        }
    }
}