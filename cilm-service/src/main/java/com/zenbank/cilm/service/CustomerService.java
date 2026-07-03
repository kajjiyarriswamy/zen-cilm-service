package com.zenbank.cilm.service;


import com.zenbank.cilm.dto.CustomerGetRequestDto;
import com.zenbank.cilm.dto.CustomerRequestDto;
import com.zenbank.cilm.dto.CustomerResponseDto;
import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerNominee;
import com.zenbank.cilm.repository.CustomerNomineeRepository;

import com.zenbank.cilm.Enum.CustomerStatus;

import com.zenbank.cilm.dto.CustomerPreferenceResponseDto;

import com.zenbank.cilm.dto.CustomerDetailsResponseDto;

import com.zenbank.cilm.dto.CustomerRequestDto;
import com.zenbank.cilm.dto.CustomerResponseDto;
import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerPreference;

import com.zenbank.cilm.repository.CustomerRepository;

import com.zenbank.cilm.dto.CustomerContactRequestDto;
import com.zenbank.cilm.dto.CustomerContactResponseDto;
import com.zenbank.cilm.entity.CustomerContact;
import com.zenbank.cilm.repository.CustomerContactRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
public class CustomerService {


    private final CustomerRepository customerRepository;
    private final CustomerNomineeRepository customerNomineeRepository;

    public CustomerService(CustomerRepository customerRepository, CustomerNomineeRepository customerNomineeRepository) {
        this.customerRepository = customerRepository;
        this.customerNomineeRepository = customerNomineeRepository;
    }

    public CustomerResponseDto createCustomer(CustomerRequestDto dto) {
        Optional<Customer> existing = customerRepository.findByEmail(dto.getEmail());
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Customer with this email already exists");
        }

      /*  Customer cu = new Customer();
        		cu.setCif_number(dto.getCif_number());
        		cu.setFirstName(dto.getFirstName());
        		cu.setMiddleName(dto.getMiddleName());
        		cu.setLastName(dto.getLastName());
        		cu.setDateOfBirth(dto.getDateOfBirth());
        		cu.setGender(dto.getGender());
        		cu.setMaritalStatus(dto.getMaritalStatus());
        		cu.setOccupation(dto.getOccupation());
        		cu.setAnnalIncome(dto.getAnnalIncome());
        		cu.setCustomerType(dto.getCustomerType());
        		cu.setCustomerCategory(dto.getCustomerCategory());
        		cu.setPanNumber(dto.getPanNumber());
        		cu.setAadhaarNumber(dto.getAadhaarNumber());
        		cu.setNationality(dto.getNationality());
        		cu.setCustomerStatus(dto.getCustomerStatus());
        		cu.setRiskCategory(dto.getRiskCategory());
        		cu.setCreatedDate(dto.getCreatedDate());
        		cu.setUpdatedDate(dto.getUpdatedDate());
        		cu.setEmail(dto.getEmail());
        		cu.setPhoneNumber(dto.getPhoneNumber());
        		cu.setAccountNumber(dto.getAccountNumber());
        		cu.setAge(dto.getAge());*/
        
        Customer customer=customerRepository.findById(dto.getCustomerId())
        		.orElseThrow(() -> new RuntimeException("Customer Not Found"));
        CustomerNominee cn=new CustomerNominee();
        
        
        cn.setCustomerId(customer);
        cn.setNomineeName(dto.getNomineeName());
        cn.setRelationship(dto.getRelationship());
        cn.setDob(dto.getDob());
        cn.setMobile(dto.getMobile());
        cn.setSharePercentage(dto.getSharePercentage());
        cn.setVerificationStatus(dto.getVerificationStatus());
        

        CustomerNominee savedCustomer = customerNomineeRepository.save(cn);
        return CustomerResponseDto.fromEntity(savedCustomer);
    }

	public List<CustomerResponseDto> getAllCustomers() {
		return customerRepository.findAll().stream().map(CustomerResponseDto::fromEntity).toList();
	}

	public Optional<CustomerResponseDto> getCustomerById(Long id) {
		return customerRepository.findById(id).map(CustomerResponseDto::fromEntity);
	}

	public void updateCustomerStatus(Long customerId, CustomerStatus status) {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));

		customer.setCustomerStatus(status);

		customerRepository.save(customer);
	}

	public CustomerDetailsResponseDto getCustomerDetails(String customerId) {
		Customer customer = customerRepository.findByCustomerId(customerId)
				.orElseThrow(() -> new IllegalArgumentException("Customer not found: " + customerId));
		return CustomerDetailsResponseDto.fromEntity(customer);
	}

	public Map<String, Object> searchCustomer(Long customerId, String cif, String phoneNumber, String pan,
			String aadhaar, String status, int page, int size) {

		Pageable pageable = PageRequest.of(page, size);

		Page<Customer> customerPage = customerRepository.searchCustomer(customerId, cif, phoneNumber, pan, aadhaar,
				status, pageable);

		List<CustomerResponseDto> customers = customerPage.getContent().stream().map(CustomerResponseDto::fromEntity)
				.toList();

		Map<String, Object> response = new LinkedHashMap<>();

		response.put("content", customers);
		response.put("page", customerPage.getNumber());
		response.put("size", customerPage.getSize());
		response.put("totalElement", customerPage.getTotalElements());

		return response;
	}


	public void updateNominee(Long customerId, 
			Long nomineeId, 
			CustomerRequestDto dto) {
		
		Customer customer=customerRepository.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Customer Not Found"));
		
		CustomerNominee nominee=customerNomineeRepository.findByNomineeIdAndCustomerId(nomineeId, customer)
				.orElseThrow(() -> new RuntimeException("Nominee Not Found"));
		
		nominee.setMobile(dto.getMobile());
		nominee.setSharePercentage(dto.getSharePercentage());
		
		customerNomineeRepository.save(nominee);
		
		
	}


	public CustomerPreferenceResponseDto getCustomerPreference(Long customerId) {

		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Customer not found"));

		CustomerPreference preference = customer.getCustomerPreference();

		if (preference == null) {
			throw new RuntimeException("Customer preferences not found.");
		}
		String preferenceId = "PREF" + String.format("%06d", preference.getPreferenceId());

		return new CustomerPreferenceResponseDto(preferenceId, preference.getLanguage(),
				preference.getCommunicationMode(), preference.getEmailEnabled(), preference.getSmsEnabled(),
				preference.getMarketingEnabled());
	}

	public CustomerPreference createPreference(Long customerId, CustomerPreference preference) {

		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Customer not found"));

		preference.setCustomer(customer);

		customer.setCustomerPreference(preference);

		customerRepository.save(customer);

		return customer.getCustomerPreference();

	public void updateCustomer(Long customerId, CustomerRequestDto requestDto) {
		Customer customer = customerRepository.findById(customerId)
	            .orElseThrow(() -> new RuntimeException("Customer not found"));

	    customer.setOccupation(requestDto.getOccupation());
	    customer.setAnnalIncome(requestDto.getAnnualIncome());
	    customer.setMaritalStatus(requestDto.getMaritalStatus());

	    customerRepository.save(customer);
	}


	
	
}

}
