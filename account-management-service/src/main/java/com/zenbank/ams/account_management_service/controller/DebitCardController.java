package com.zenbank.ams.account_management_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zenbank.ams.account_management_service.dto.DebitCardRequest;
import com.zenbank.ams.account_management_service.dto.DebitCardResponse;
import com.zenbank.ams.account_management_service.service.DebitCardService;

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
}