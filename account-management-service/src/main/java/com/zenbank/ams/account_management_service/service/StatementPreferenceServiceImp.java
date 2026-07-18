package com.zenbank.ams.account_management_service.service;

import java.util.Map;

import com.zenbank.ams.account_management_service.dto.CreateStatementPreferenceRequest;
import com.zenbank.ams.account_management_service.dto.StatementPreferenceResponse;
import com.zenbank.ams.account_management_service.entity.AccountStatementPreference;

import jakarta.validation.Valid;

public interface StatementPreferenceServiceImp {

	StatementPreferenceResponse createStatementPreference(Long accountId, CreateStatementPreferenceRequest requestDto);

	StatementPreferenceResponse getStatementPreference(Long accountId);

	StatementPreferenceResponse updateStatement(Long accountId,  CreateStatementPreferenceRequest dto);

	Map<String, Object> searchAccount(Long accountId, String statementType, String statementFrequency,
			String deliveryStatus, int page, int size);

	
}
