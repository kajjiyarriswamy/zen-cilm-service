package com.zenbank.cilm.controller;

import com.zenbank.cilm.dto.CustomerGetRequestDto;
import com.zenbank.cilm.dto.CustomerRequestDto;
import com.zenbank.cilm.dto.CustomerResponseDto;
import com.zenbank.cilm.service.CustomerService;
import com.zenbank.cilm.utility.ApiResponseUtil;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<Map<String, Object>> createCustomer(@Valid @RequestBody CustomerGetRequestDto requestDto) {
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
    
    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> searchCustomer(
    		@RequestParam(required = false) Long customerId,
    		@RequestParam(required = false) String cif,
    		@RequestParam(required = false) String phoneNumber,
    		@RequestParam(required = false) String pan,
    		@RequestParam(required = false) String aadhaar,
    		@RequestParam(required = false) String status,
    		@RequestParam(defaultValue = "0") int page,
    		@RequestParam(defaultValue = "10") int size
    		) {
    	
    	return ResponseEntity.ok(ApiResponseUtil.success(customerService.searchCustomer(customerId,
    			cif, phoneNumber,
    			pan, aadhaar, 
    			status, page,
    			size)));
    }
    
    @GetMapping("/{customerId}/addresses")
    public ResponseEntity<Map<String, Object>> getCustomerAddresses(
            @PathVariable Long customerId) {

        Map<String, Object> response =
                customerService.getCustomerAddresses(customerId);

        if ("FAILED".equals(response.get("status"))) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{customerId}/addresses/{addressId}")
    public ResponseEntity<Map<String,Object>> deleteCustomerAddress(
            @PathVariable Long customerId,
            @PathVariable Long addressId){

        Map<String,Object> response=
                customerService.deleteCustomerAddress(customerId,addressId);

        if("FAILED".equals(response.get("status"))){

            return ResponseEntity.badRequest().body(response);

        }

        return ResponseEntity.ok(response);

    }
}
