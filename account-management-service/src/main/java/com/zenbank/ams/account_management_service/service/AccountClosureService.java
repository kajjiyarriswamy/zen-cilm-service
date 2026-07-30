package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.AccountClosureResponseDto;
import com.zenbank.ams.account_management_service.dto.CancelAccountClosureRequestDto;
import com.zenbank.ams.account_management_service.dto.CloseAccountRequestDto;
import com.zenbank.ams.account_management_service.dto.CloseAccountResponseDto;

public interface AccountClosureService {
	CloseAccountResponseDto closeAccount(Long accountId,CloseAccountRequestDto request);
	AccountClosureResponseDto cancelAccountClosureRequest(Long accountId,CancelAccountClosureRequestDto request);
}
