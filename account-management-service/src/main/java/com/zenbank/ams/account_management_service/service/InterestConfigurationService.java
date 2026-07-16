package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.CreateInterestConfigurationRequest;
import com.zenbank.ams.account_management_service.dto.InterestConfigurationResponse;
import com.zenbank.ams.account_management_service.dto.ViewInterestConfigurationResponseDto;

public interface InterestConfigurationService {
	
	InterestConfigurationResponse createInterestConfiguration(
            CreateInterestConfigurationRequest request);
	ViewInterestConfigurationResponseDto viewInterestConfiguration();
}
