package com.zenbank.cilm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.cilm.dto.CustomerPreferenceRequestDto;
import com.zenbank.cilm.dto.CustomerPreferenceResponseDto;
import com.zenbank.cilm.entity.CustomerPreferences;
import com.zenbank.cilm.service.CustomerPreferencesService;
import com.zenbank.cilm.utility.ApiResponseUtil;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/customers")
public class CustomerPreferencesController {

    @Autowired
    private CustomerPreferencesService customerPreferencesService;

    
    @PostMapping("/{customerId}/preferences")
    public ResponseEntity<CustomerPreferenceResponseDto> createCustomerPreference(
            @PathVariable String customerId,
            @RequestBody CustomerPreferenceRequestDto requestDto) {

        CustomerPreferenceResponseDto response =
                customerPreferencesService.createCustomerPreference(customerId, requestDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
   /* @PostMapping("/{customerId}")
    public ResponseEntity<CustomerPreferenceResponseDto> createCustomerPreference(
            @PathVariable String customerId,
            @RequestBody CustomerPreferenceRequestDto requestDto) {

        CustomerPreferenceResponseDto response =
                customerPreferencesService.createCustomerPreference(customerId, requestDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }*/
}
}