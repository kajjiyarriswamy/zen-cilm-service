package com.zenbank.ams.account_management_service.service;

import java.util.List;

import com.zenbank.ams.account_management_service.dto.AccountRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountResponseDto;
import com.zenbank.ams.account_management_service.dto.CustomerAccountsResponseDto;

public interface AccountServiceI {
	public AccountResponseDto accountCreate(AccountRequestDto requestdto);
	public List<CustomerAccountsResponseDto> getAccountsByCustomerId(String custId);
}
