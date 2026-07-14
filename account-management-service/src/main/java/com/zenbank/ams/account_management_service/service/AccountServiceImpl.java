package com.zenbank.ams.account_management_service.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountServiceI {
	
	@Autowired
    private AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {
		 account.setCreatedDate(LocalDateTime.now());
	        account.setUpdatedDate(LocalDateTime.now());
	        account.setOpenedDate(LocalDateTime.now());

	        return accountRepository.save(account);
	}

}
