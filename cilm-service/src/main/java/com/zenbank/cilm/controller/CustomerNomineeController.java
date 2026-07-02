package com.zenbank.cilm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.cilm.dto.CustomerNomineeRequestDto;
import com.zenbank.cilm.dto.CustomerNomineeResponseDto;
import com.zenbank.cilm.service.CustomerNomineeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerNomineeController {
	 private final CustomerNomineeService customerNomineeService;

	    public CustomerNomineeController(CustomerNomineeService customerNomineeService) {
	        this.customerNomineeService = customerNomineeService;
	    }

	    @PostMapping("/{customerId}/nominees")
	    public ResponseEntity<CustomerNomineeResponseDto> addNominee(
	            @PathVariable String customerId,
	            @RequestBody CustomerNomineeRequestDto requestDto) {

	        return ResponseEntity.ok(
	                customerNomineeService.addNominee(customerId, requestDto));
	    }
	}


