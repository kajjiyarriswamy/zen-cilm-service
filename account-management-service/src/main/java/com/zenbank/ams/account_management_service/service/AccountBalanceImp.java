package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.AccountBalanceResponse;

public interface AccountBalanceImp {

    <AccountBalanceResponse> Object getAccountBalance(Long accountId);
}
