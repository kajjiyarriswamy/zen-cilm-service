package com.zenbank.cilm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zenbank.cilm.dto.CustomerPreferenceRequestDto;
import com.zenbank.cilm.dto.CustomerPreferenceResponseDto;
import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerPreferenceEntity;
import com.zenbank.cilm.repository.CustomerPreferenceRepository;
import com.zenbank.cilm.repository.CustomerRepository;

import jakarta.validation.Valid;

@Service
public class CustomerPreferenceService {
	
	private final CustomerPreferenceRepository preferenceRepository;
	private final CustomerRepository customerRepository;
	
	public CustomerPreferenceService(CustomerPreferenceRepository
			preferenceRepository, CustomerRepository customerRepository) {
		
		this.preferenceRepository= preferenceRepository;
		this.customerRepository = customerRepository;
		
	}

	public CustomerPreferenceResponseDto createPreference(@Valid CustomerPreferenceRequestDto dto) {
		
		Customer customer=customerRepository.findById(dto.getCustomerId())
				.orElseThrow(() -> new RuntimeException("Customer not Found"));
		
		CustomerPreferenceEntity cpe=new CustomerPreferenceEntity();
		
		cpe.setCustomer(customer);
		cpe.setLanguage(dto.getLanguage());
		cpe.setRelationship(dto.getRelationship());
		cpe.setCommunicationMode(dto.getCommunicationMode());
		cpe.setEmailEnabled(dto.getEmailEnabled());
		cpe.setSmsEnabled(dto.getSmsEnabled());
		cpe.setMarketingEnabled(dto.getMarketingEnabled());
		
		CustomerPreferenceEntity saved=preferenceRepository.save(cpe);
		
		return CustomerPreferenceResponseDto.fromEntity(saved);
	}

	public List<CustomerPreferenceResponseDto> getAllPreferences() {
		
		return preferenceRepository.findAll()
				.stream()
				.map(CustomerPreferenceResponseDto::fromEntity)
				.toList();
	}

	public Optional<CustomerPreferenceResponseDto> getPreferenceById(Long id) {

	    return preferenceRepository.findById(id)
	            .map(CustomerPreferenceResponseDto::fromEntity);
	}

}
