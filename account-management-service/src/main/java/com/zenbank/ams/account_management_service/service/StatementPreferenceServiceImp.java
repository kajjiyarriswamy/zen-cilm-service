package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.CreateStatementPreferenceRequest;
import com.zenbank.ams.account_management_service.dto.StatementPreferenceResponse;

public interface StatementPreferenceServiceImp {

	StatementPreferenceResponse createStatementPreference(Long accountId, CreateStatementPreferenceRequest requestDto);
}
