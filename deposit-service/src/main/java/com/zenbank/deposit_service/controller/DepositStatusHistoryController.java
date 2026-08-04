package com.zenbank.deposit_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zenbank.deposit_service.dto.DepositStatusHistoryGetApiResponse;
import com.zenbank.deposit_service.dto.DepositStatusHistoryRequest;
import com.zenbank.deposit_service.dto.DepositStatusHistoryResponse;
import com.zenbank.deposit_service.dto.DepositTransactionResponse;
import com.zenbank.deposit_service.service.DepositStatusHistoryService;

@RestController
@RequestMapping("/api/deposit-status-history")
public class DepositStatusHistoryController {

    @Autowired
    private DepositStatusHistoryService depositStatusHistoryService;

    @PostMapping
    public ResponseEntity<DepositStatusHistoryResponse> createStatusHistory(
            @RequestBody DepositStatusHistoryRequest request) {

        DepositStatusHistoryResponse response =
                depositStatusHistoryService.createStatusHistory(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/{depositId}")
    public ResponseEntity<DepositStatusHistoryGetApiResponse> getStatusHistoryByDepositId(
            @PathVariable Long depositId) {

        DepositStatusHistoryGetApiResponse response =
                depositStatusHistoryService.getStatusHistoryByDepositId(depositId);

        return ResponseEntity.ok(response);
    }

    

}