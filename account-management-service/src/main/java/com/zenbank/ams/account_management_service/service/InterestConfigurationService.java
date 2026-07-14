package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.CreateInterestConfigurationRequest;
import com.zenbank.ams.account_management_service.dto.InterestConfigurationResponse;

public interface InterestConfigurationService {
	
	InterestConfigurationResponse createInterestConfiguration(
            CreateInterestConfigurationRequest request);
}
