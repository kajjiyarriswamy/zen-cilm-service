package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.AccountRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountResponseDto;

public interface AccountServiceI {
	public AccountResponseDto accountCreate(AccountRequestDto requestdto);
}
