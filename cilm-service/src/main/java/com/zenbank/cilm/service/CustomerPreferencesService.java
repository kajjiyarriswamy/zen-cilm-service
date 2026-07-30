package com.zenbank.cilm.service;

import com.zenbank.cilm.dto.CustomerPreferenceRequestDto;
import com.zenbank.cilm.dto.CustomerPreferenceResponseDto;
import com.zenbank.cilm.repository.CustomerPreferencesRepository;

public interface CustomerPreferencesService {
	
	 
	 
	CustomerPreferenceResponseDto createPreference(
            String customerId,
            CustomerPreferenceRequestDto request
    );
	
	
	
	

}
