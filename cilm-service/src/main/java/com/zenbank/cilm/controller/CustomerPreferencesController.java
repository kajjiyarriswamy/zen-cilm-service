package com.zenbank.cilm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.cilm.dto.CustomerPreferenceRequestDto;
import com.zenbank.cilm.dto.CustomerPreferenceResponseDto;
import com.zenbank.cilm.service.CustomerPreferencesService;


@RestController
@RequestMapping("/api/v1/customers")
public class CustomerPreferencesController {


    @Autowired
    private CustomerPreferencesService customerPreferenceService;


    @PostMapping("/{customerId}/preferences")
    public ResponseEntity<CustomerPreferenceResponseDto> createPreference(
            @PathVariable String customerId,
            @RequestBody CustomerPreferenceRequestDto request) {


        CustomerPreferenceResponseDto response =
                customerPreferenceService.createPreference(
                        customerId, request);


        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED);
    }
}