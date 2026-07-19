package com.zenbank.ams.account_management_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.ams.account_management_service.dto.AccountFreezeRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountFreezeResponseDto;
import com.zenbank.ams.account_management_service.service.AccountFreezeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountFreezeController {
	@Autowired
    private AccountFreezeService accountFreezeService;

    @PostMapping("/{accountId}/freeze/debit")
    public ResponseEntity<AccountFreezeResponseDto> freezeDebit(
            @PathVariable Long accountId,
            @Valid @RequestBody AccountFreezeRequestDto request) {

        AccountFreezeResponseDto response =
                accountFreezeService.freezeDebit(accountId, request);

        return ResponseEntity.ok(response);
    }
}
