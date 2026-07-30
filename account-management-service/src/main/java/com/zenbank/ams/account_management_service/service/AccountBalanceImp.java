package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.AccountBalanceResponse;

public interface AccountBalance {

    AccountBalanceResponse getAccountBalance(Long accountId);
}
