package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.AccountLimitRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountLimitResponseDto;

public interface IAccountLimitService {
	
	public AccountLimitResponseDto createAccountLimit(AccountLimitRequestDto dto,Long accountId);

}
