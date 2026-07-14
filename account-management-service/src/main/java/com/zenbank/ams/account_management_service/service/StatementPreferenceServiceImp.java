package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.CreateStatementPreferenceRequest;
import com.zenbank.ams.account_management_service.dto.StatementPreferenceResponse;
import com.zenbank.ams.account_management_service.entity.AccountStatementPreference;

public interface StatementPreferenceServiceImp {

	StatementPreferenceResponse createStatementPreference(Long accountId, CreateStatementPreferenceRequest requestDto);

	StatementPreferenceResponse getStatementPreference(Long accountId);

	
}
