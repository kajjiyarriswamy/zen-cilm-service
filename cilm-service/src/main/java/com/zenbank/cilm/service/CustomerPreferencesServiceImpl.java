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
	private  CustomerRepository customerRepository;

	@Autowired
    private  CustomerPreferencesRepository customerPreferencesRepository;

	@Override
	public CustomerPreferenceResponseDto createPreference(String customerId, CustomerPreferenceRequestDto request) {
		
		
		// Check customer exists
        Customer customer = customerRepository
                .findByCustomerId(customerId)
                .orElseThrow(() -> 
                    new RuntimeException(
                    "Customer not found with id: " + customerId));


        // Check preference already exists
        if (customerPreferencesRepository
                .findByCustomerCustomerId(customerId)
                .isPresent()) {

            throw new RuntimeException(
                    "Customer preference already exists");
        }

        // Create preference entity
        CustomerPreferences preference =
                new CustomerPreferences();


        preference.setCustomer(customer);

        preference.setLanguage(
                request.getLanguage());

        preference.setCommunicationMode(
                request.getCommunicationMode());

        preference.setEmailEnabled(
                request.getEmailEnabled());

        preference.setSmsEnabled(
                request.getSmsEnabled());

        preference.setMarketingEnabled(
                request.getMarketingEnabled());


        // Save
        CustomerPreferences savedPreference =
                customerPreferencesRepository.save(preference);



        // Response DTO
        CustomerPreferenceResponseDto response =
                new CustomerPreferenceResponseDto();


        response.setPreferenceId(
                savedPreference.getPreferenceId());

        response.setCustomerId(
                customer.getCustomerId());

        response.setLanguage(
                savedPreference.getLanguage());

        response.setCommunicationMode(
                savedPreference.getCommunicationMode());

        response.setEmailEnabled(
                savedPreference.getEmailEnabled());

        response.setSmsEnabled(
                savedPreference.getSmsEnabled());

        response.setMarketingEnabled(
                savedPreference.getMarketingEnabled());


        return response;
    }
}
   

   