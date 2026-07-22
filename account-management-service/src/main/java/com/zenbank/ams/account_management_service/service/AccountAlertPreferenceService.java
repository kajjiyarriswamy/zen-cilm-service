package com.zenbank.ams.account_management_service.service;

import org.springframework.stereotype.Service;

import com.zenbank.ams.account_management_service.dto.AccountAlertPreferenceResponse;
import com.zenbank.ams.account_management_service.dto.CreateAccountAlertPreferenceRequest;

@Service
public interface AccountAlertPreferenceService {
	
	AccountAlertPreferenceResponse createPreferance(
			Long accountId, CreateAccountAlertPreferenceRequest request);
	
	

}
