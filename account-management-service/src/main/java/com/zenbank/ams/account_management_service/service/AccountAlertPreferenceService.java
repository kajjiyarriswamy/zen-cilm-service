package com.zenbank.ams.account_management_service.service;

import org.springframework.stereotype.Service;

import com.zenbank.ams.account_management_service.dto.AccountAlertPreferenceResponse;
import com.zenbank.ams.account_management_service.dto.CreateAccountAlertPreferenceRequest;
import com.zenbank.ams.account_management_service.dto.GetAlertPreference;

@Service
public interface AccountAlertPreferenceService {
	
	AccountAlertPreferenceResponse createPreferance(
			Long accountId, CreateAccountAlertPreferenceRequest request);
	
	GetAlertPreference getAlertPreference(Long accountId);
	
	
	AccountAlertPreferenceResponse updateAlertPreference(
	        Long accountId,
	        CreateAccountAlertPreferenceRequest request);

}
