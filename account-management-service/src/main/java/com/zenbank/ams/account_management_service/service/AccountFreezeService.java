package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.AccountFreezeRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountFreezeResponseDto;

public interface AccountFreezeService {
	AccountFreezeResponseDto freezeDebit(Long accountId, AccountFreezeRequestDto request);
	AccountFreezeResponseDto freezeCredit(Long accountId, AccountFreezeRequestDto request);
	AccountFreezeResponseDto unfreezeAccount(Long accountId,AccountFreezeRequestDto request);
}
