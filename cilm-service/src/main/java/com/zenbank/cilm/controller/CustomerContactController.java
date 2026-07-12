package com.zenbank.cilm.controller;

import com.zenbank.cilm.dto.CustomerContactRequestDto;
import com.zenbank.cilm.dto.CustomerContactResponseDto;
import com.zenbank.cilm.service.CustomerService;
import jakarta.validation.Valid;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerContactController {

    private final CustomerService customerService;

    public CustomerContactController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/{customerId}/contacts")
    public ResponseEntity<?> addContact(@PathVariable String customerId,
                                        @Validated(CustomerContactRequestDto.Create.class) @RequestBody CustomerContactRequestDto requestDto) {
        try {
            CustomerContactResponseDto response =
                    customerService.addContact(customerId, requestDto);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new CustomerContactResponseDto("FAILED", e.getMessage(), null, null));
        }
    }
    @PutMapping("/{customerId}/contacts/mobile")
    public ResponseEntity<CustomerContactResponseDto> updateCustomerContactPhoneNumber(
            @PathVariable String customerId, @RequestBody CustomerContactRequestDto contactRequestDto) {
        return ResponseEntity.ok(customerService.updateMobileNumber(customerId, contactRequestDto));
    }

    @PutMapping("/{customerId}/contacts/email")
    public ResponseEntity<CustomerContactResponseDto> updateCustomerContactEmail(
            @PathVariable String customerId, @Valid @RequestBody CustomerContactRequestDto customerContactRequestDto){
        return ResponseEntity.ok(customerService.updateEmail(customerId, customerContactRequestDto));
    }

//    get customer contact details by customerId
    @GetMapping("/{customerId}/contacts")
    public ResponseEntity<Map<String, Object>> getCustomerContacts(@PathVariable String customerId) {
        Map<String, Object> response = customerService.getContactsByCustomerId(customerId);
        if ("FAILED".equals(response.get("status"))) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        return ResponseEntity.ok(response);
    }

}
