package com.zenbank.ams.account_management_service.controller;

import com.zenbank.ams.account_management_service.dto.AccountCheckBookRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountCheckBookResponseDto;
import com.zenbank.ams.account_management_service.service.AccountCheckBookRequestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountCheckBookRequestController {

    private final AccountCheckBookRequestService accountCheckBookRequestService;

    public AccountCheckBookRequestController(AccountCheckBookRequestService accountCheckBookRequestService) {
        this.accountCheckBookRequestService = accountCheckBookRequestService;
    }

    @PostMapping("/{accountId}/cheque-book")
    public ResponseEntity<AccountCheckBookResponseDto> createChequeBookRequest(@PathVariable Long accountId,
            @Valid @RequestBody AccountCheckBookRequestDto requestDto) {

        AccountCheckBookResponseDto response = accountCheckBookRequestService.createAccountCheckBookRequest(requestDto,
                accountId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
