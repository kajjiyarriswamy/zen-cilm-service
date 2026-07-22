package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.CreateInterestConfigurationRequest;
import com.zenbank.ams.account_management_service.dto.InterestConfigurationResponse;
import com.zenbank.ams.account_management_service.dto.UpdateInterestConfigurationRequest;
import com.zenbank.ams.account_management_service.dto.UpdateInterestConfigurationResponseDto;
import com.zenbank.ams.account_management_service.dto.ViewInterestConfigurationResponseDto;
public interface InterestConfigurationService {
	
	InterestConfigurationResponse createInterestConfiguration(
            CreateInterestConfigurationRequest request);
	ViewInterestConfigurationResponseDto viewInterestConfiguration();
	UpdateInterestConfigurationResponseDto updateInterestConfiguration(Long interestId, UpdateInterestConfigurationRequest req);
}
