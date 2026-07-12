package com.zenbank.cilm.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.cilm.dto.CustomerNomineeRequestDto;
import com.zenbank.cilm.dto.CustomerNomineeResponseDto;
import com.zenbank.cilm.service.CustomerNomineeService;
import com.zenbank.cilm.utility.ApiResponseUtil;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerNomineeController {
    private final CustomerNomineeService customerNomineeService;

    public CustomerNomineeController(CustomerNomineeService customerNomineeService) {
        this.customerNomineeService = customerNomineeService;
    }

    @PostMapping("/{customerId}/nominees")
    public ResponseEntity<Map<String, Object>> addNominee(
            @PathVariable String customerId,
            @Valid @RequestBody CustomerNomineeRequestDto requestDto) {

        CustomerNomineeResponseDto response =
                customerNomineeService.addNominee(customerId, requestDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponseUtil.created("Nominee added successfully.", response));
    }

}
