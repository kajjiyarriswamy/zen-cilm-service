package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.AccountChequeBookRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountChequeBookResponseDto;
import com.zenbank.ams.account_management_service.dto.AccountChequeBookSearchResponseDto;

import java.time.LocalDate;

public interface AccountChequeBookRequestService {

    AccountChequeBookResponseDto createAccountChequeBookRequest(AccountChequeBookRequestDto accountChequeBookRequestDto, Long accountId);
    AccountChequeBookResponseDto getChequeBookRequest(Long accountId, Long chequeBookRequestId);

    AccountChequeBookSearchResponseDto searchChequeBookRequests(
            String accountNumber,
            String customerId,
            String requestStatus,
            String chequeBookType,
            String requestMode,
            LocalDate fromDate,
            LocalDate toDate,
            int page,
            int size
    );
}
