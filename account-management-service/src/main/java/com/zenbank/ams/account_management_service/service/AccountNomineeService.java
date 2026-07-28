package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.AccountNomineeRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountNomineeResponseDto;

public interface AccountNomineeService {
	AccountNomineeResponseDto addNominee(Long accountId,
            AccountNomineeRequestDto requestDto);
}
