package com.zenbank.ams.account_management_service.controller;

import com.zenbank.ams.account_management_service.dto.AccountChequeBookRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountChequeBookResponseDto;
import com.zenbank.ams.account_management_service.dto.AccountChequeBookSearchResponseDto;
import com.zenbank.ams.account_management_service.service.AccountChequeBookRequestService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountChequeBookRequestController {

    private final AccountChequeBookRequestService accountChequeBookRequestService;

    public AccountChequeBookRequestController(AccountChequeBookRequestService accountChequeBookRequestService) {
        this.accountChequeBookRequestService = accountChequeBookRequestService;
    }

    @PostMapping("/{accountId}/cheque-books")
    public ResponseEntity<AccountChequeBookResponseDto> createChequeBookRequest(@PathVariable Long accountId,
                                                                                @Valid @RequestBody AccountChequeBookRequestDto requestDto) {

        AccountChequeBookResponseDto response = accountChequeBookRequestService.createAccountChequeBookRequest(requestDto,
                accountId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{accountId}/chequeBook/{chequeBookRequestId}")
    public ResponseEntity<AccountChequeBookResponseDto> getChequeBookRequestById(@PathVariable Long accountId, @PathVariable Long chequeBookRequestId) {
        AccountChequeBookResponseDto response = accountChequeBookRequestService.getChequeBookRequest(accountId, chequeBookRequestId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{accountId}/chequeBook/{chequeBookRequestId}")
    public ResponseEntity<AccountChequeBookResponseDto> updateChequeBookRequest(@PathVariable Long accountId, @PathVariable Long chequeBookRequestId, @RequestBody AccountChequeBookRequestDto requestDto) {
        AccountChequeBookResponseDto responseDto = accountChequeBookRequestService.updateChequeRequest(requestDto,accountId, chequeBookRequestId);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/search/chequebook")
    public ResponseEntity<AccountChequeBookSearchResponseDto> search(

            @RequestParam(required = false) String accountNumber,

            @RequestParam(required = false) String customerId,

            @RequestParam(required = false) String requestStatus,

            @RequestParam(required = false) String chequeBookType,

            @RequestParam(required = false) String requestMode,

            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fromDate,

            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate toDate,

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "10")
            int size){

        AccountChequeBookSearchResponseDto response = accountChequeBookRequestService.searchChequeBookRequests(
                accountNumber, customerId, requestStatus, chequeBookType,
                requestMode, fromDate, toDate, page, size);

        return ResponseEntity.ok(accountChequeBookRequestService.searchChequeBookRequests(
                accountNumber, customerId, requestStatus, chequeBookType,
                requestMode, fromDate, toDate, page, size
        ));
    }
}
