package com.zenbank.ams.account_management_service.service;


import com.zenbank.ams.account_management_service.dto.AccountRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountResponseDto;
import com.zenbank.ams.account_management_service.entity.Account;

public interface AccountServiceI {
	public AccountResponseDto accountCreate(AccountRequestDto requestdto);


}
