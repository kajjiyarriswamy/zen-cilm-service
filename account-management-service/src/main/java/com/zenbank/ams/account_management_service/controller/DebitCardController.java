package com.zenbank.ams.account_management_service.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zenbank.ams.account_management_service.dto.DebitCardRequest;
import com.zenbank.ams.account_management_service.dto.DebitCardResponse;
import com.zenbank.ams.account_management_service.dto.DebitCardResponseDto;
import com.zenbank.ams.account_management_service.dto.DebitCardUpdateResponse;
import com.zenbank.ams.account_management_service.dto.UpdateDebitCardRequest;
import com.zenbank.ams.account_management_service.service.DebitCardService;
import com.zenbank.ams.account_management_service.utility.ApiResponseUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/accounts")
public class DebitCardController {

    private final DebitCardService debitCardService;

    public DebitCardController(DebitCardService debitCardService) {
        this.debitCardService = debitCardService;
    }

    @PostMapping("/{accountId}/debit-cards")
    public ResponseEntity<DebitCardResponse> createDebitCardRequest(
            @PathVariable Long accountId,
            @Valid @RequestBody DebitCardRequest requestDto) {

        DebitCardResponse response =
                debitCardService.createDebitCardRequest(requestDto, accountId);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @GetMapping("/{accountId}/debit-cards/{debitCardId}")
    public ResponseEntity<Map<String, Object>> getDebitCardByAccountIdAndDebitCardId(
            @PathVariable Long accountId,
            @PathVariable Long debitCardId) {

        DebitCardResponseDto response = debitCardService
                .getDebitCardByAccountIdAndDebitCardId(accountId, debitCardId);

        return ResponseEntity.ok(ApiResponseUtil.created(response));
    }
    @PutMapping("/{accountId}/debit-cards/{debitCardId}")
    
    public ResponseEntity<DebitCardUpdateResponse> updateDebitCardRequest(
            @PathVariable Long accountId,
            @PathVariable Long debitCardId,
            @Valid @RequestBody UpdateDebitCardRequest request) {

        DebitCardUpdateResponse response = debitCardService
                .updateDebitCardRequest(accountId, debitCardId, request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}