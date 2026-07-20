package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.AccountLimitRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountLimitResponseDto;
import com.zenbank.ams.account_management_service.dto.GetAccountLimitResponseDto;
import com.zenbank.ams.account_management_service.dto.UpdateAccountLimitResponseDto;

public interface IAccountLimitService {
	
	public AccountLimitResponseDto createAccountLimit(AccountLimitRequestDto dto,Long accountId);
	
	public UpdateAccountLimitResponseDto updateAccountLimit(AccountLimitRequestDto dto,Long accountId);
	
	public GetAccountLimitResponseDto getAccountLimit(Long accountId);

}
