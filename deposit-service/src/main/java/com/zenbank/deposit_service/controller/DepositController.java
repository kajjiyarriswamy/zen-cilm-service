package com.zenbank.deposit_service.controller;

import com.zenbank.deposit_service.dto.CreateDepositRequest;
import com.zenbank.deposit_service.dto.DepositSearchResponse;
import com.zenbank.deposit_service.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DepositController {

    @Autowired
    private DepositService depositService;

    @PostMapping(value = "/deposits", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DepositSearchResponse> createDeposit(@RequestBody CreateDepositRequest request) {
        DepositSearchResponse response = depositService.executeDeposit(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
