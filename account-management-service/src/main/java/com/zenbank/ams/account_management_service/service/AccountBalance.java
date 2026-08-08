package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.AccountBalanceResponse;
import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.exception.AccountNotFoundException;
import com.zenbank.ams.account_management_service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AccountBalance implements AccountBalanceImp {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountBalanceResponse response;

    @Override
    public AccountBalanceResponse getAccountBalance(Long accountId) {

        Account account = accountRepository.findById(accountId).
                orElseThrow(()-> new AccountNotFoundException("Account is not Found!!!"));

        return new AccountBalanceResponse(
                account.getAccountId(),
                account.getAvailableBalance(),
                account.getLedgerBalance()
        );
    }
}
