package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.AccountChequeBookRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountChequeBookResponseDto;

public interface AccountChequeBookRequestService {

    AccountChequeBookResponseDto createAccountChequeBookRequest(AccountChequeBookRequestDto accountChequeBookRequestDto, Long accountId);
    AccountChequeBookResponseDto getChequeBookRequest(Long accountId, Long chequeBookRequestId);
}
