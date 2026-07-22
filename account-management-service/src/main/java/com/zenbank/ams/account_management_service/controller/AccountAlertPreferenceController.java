package com.zenbank.ams.account_management_service.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.zenbank.ams.account_management_service.dto.AccountAlertPreferenceResponse;
import com.zenbank.ams.account_management_service.dto.CreateAccountAlertPreferenceRequest;
import com.zenbank.ams.account_management_service.service.AccountAlertPreferenceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/accounts")
@Validated
public class AccountAlertPreferenceController {

    private final AccountAlertPreferenceService service;

    public AccountAlertPreferenceController(
            AccountAlertPreferenceService service) {
        this.service = service;
    }

    @PostMapping("/{accountId}/alert-preferences")
    public ResponseEntity<AccountAlertPreferenceResponse> createPreference(
            @PathVariable Long accountId,
            @Valid @RequestBody CreateAccountAlertPreferenceRequest request) {

        return new ResponseEntity<>(
                service.createPreferance(accountId, request),
                HttpStatus.CREATED);
    }
}