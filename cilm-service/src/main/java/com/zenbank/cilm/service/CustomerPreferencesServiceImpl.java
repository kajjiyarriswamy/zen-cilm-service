package com.zenbank.cilm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenbank.cilm.dto.CustomerPreferenceRequestDto;
import com.zenbank.cilm.dto.CustomerPreferenceResponseDto;
import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerPreferences;
import com.zenbank.cilm.repository.CustomerPreferencesRepository;
import com.zenbank.cilm.repository.CustomerRepository;


@Service
public class CustomerPreferencesServiceImpl implements CustomerPreferencesService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerPreferencesRepository customerPreferencesRepository;

	@Override
	public CustomerPreferenceResponseDto createCustomerPreference(
	        String customerId,
	        CustomerPreferenceRequestDto requestDto) {

	    Customer customer = customerRepository.findByCustomerId(customerId)
	            .orElseThrow(() -> new RuntimeException("Customer not found."));

	        // Create entity
	        CustomerPreferences preference = new CustomerPreferences();

	        
	        preference.setCustomer(customer);
	        preference.setLanguage(requestDto.getLanguage());
	        preference.setCommunicationMode(requestDto.getCommunicationMode());
	        preference.setEmailEnabled(requestDto.getEmailEnabled());
	        preference.setSmsEnabled(requestDto.getSmsEnabled());
	        preference.setMarketingEnabled(requestDto.getMarketingEnabled());

	        // Save entity
	        CustomerPreferences savedPreference =
	        		customerPreferencesRepository.save(preference);
	       // CustomerPreferences savedPreference = customerPreferencesRepository.save(preference);

	        // Prepare response
	        CustomerPreferenceResponseDto response = new CustomerPreferenceResponseDto();
	        response.setStatus("SUCCESS");
	        response.setMessage("Customer preferences created successfully.");
	        response.setPreferenceId(savedPreference.getPreferenceId());

	        return response;
	    }
	}

	
