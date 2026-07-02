package com.zenbank.cilm.service;


import com.zenbank.cilm.Enum.CustomerStatus;
import com.zenbank.cilm.dto.CustomerPreferenceResponseDto;

import com.zenbank.cilm.dto.CustomerDetailsResponseDto;

import com.zenbank.cilm.dto.CustomerRequestDto;
import com.zenbank.cilm.dto.CustomerResponseDto;
import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerPreference;
import com.zenbank.cilm.repository.CustomerRepository;

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

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
   


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public CustomerResponseDto createCustomer(CustomerRequestDto requestDto) {
        if (customerRepository.existsByPanNumber(requestDto.getPanNumber())) {
            throw new IllegalArgumentException("PAN Number already exists.");
        }

        if (customerRepository.existsByAadhaarNumber(requestDto.getAadhaarNumber())) {
            throw new IllegalArgumentException("Aadhaar Number already exists.");
        }

        if (customerRepository.existsByPhoneNumber(requestDto.getPhoneNumber())) {
            throw new IllegalArgumentException("Mobile Number already exists.");
        }

        int age = Period.between(requestDto.getDateOfBirth(), LocalDate.now()).getYears();

        if (age < 18) {
            throw new IllegalArgumentException("Customer age should be 18 years or above.");
        }
        Optional<Customer> existing = customerRepository.findByEmail(requestDto.getEmail());

        if (existing.isPresent()) {
            throw new IllegalArgumentException("Customer with this email already exists");
        }



        Customer customer = new Customer();

        Random random = new Random();
        customer.setCif_number("CIF"+ String.valueOf(10000000+random.nextInt(90000000)));
        customer.setFirstName(requestDto.getFirstName());
        customer.setMiddleName(requestDto.getMiddleName());
        customer.setLastName(requestDto.getLastName());
        customer.setAge(requestDto.getAge());
        customer.setDateOfBirth(requestDto.getDateOfBirth());
        customer.setGender(requestDto.getGender());
        customer.setMaritalStatus(requestDto.getMaritalStatus());
        customer.setOccupation(requestDto.getOccupation());
        customer.setAnnalIncome(requestDto.getAnnualIncome());
        customer.setCustomerType(requestDto.getCustomerType());
        customer.setCustomerCategory(requestDto.getCustomerCategory());
        customer.setEmail(requestDto.getEmail());
        customer.setPhoneNumber(requestDto.getPhoneNumber());
        customer.setAadhaarNumber(requestDto.getAadhaarNumber());
        customer.setPanNumber(requestDto.getPanNumber());
        customer.setNationality(requestDto.getNationality());
        customer.setAccountNumber("SBI-"+String.valueOf(10000000+random.nextInt(90000000)));
        customer.setCreatedDate(LocalDate.now());


        Customer savedCustomer = customerRepository.save(customer);
        return CustomerResponseDto.fromEntity(savedCustomer);
    }

    public List<CustomerResponseDto> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerResponseDto::fromEntity)
                .toList();
    }

    public Optional<CustomerResponseDto> getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(CustomerResponseDto::fromEntity);
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


	public Map<String, Object> searchCustomer(Long customerId, String cif, String phoneNumber, String pan, String aadhaar,
			String status, int page, int size) {
		
		Pageable pageable=PageRequest.of(page, size);
		
		Page<Customer> customerPage= customerRepository.searchCustomer(customerId,
				cif, 
				phoneNumber, 
				pan, 
				aadhaar, 
				status, pageable);
		
		List<CustomerResponseDto> customers = customerPage.getContent()
				.stream()
				.map(CustomerResponseDto::fromEntity)
				.toList();
		
		Map<String, Object> response = new LinkedHashMap<>();
		
		response.put("content", customers);
		response.put("page", customerPage.getNumber());
		response.put("size", customerPage.getSize());
		response.put("totalElement", customerPage.getTotalElements());
		
		return response;
	}
	
	public CustomerPreferenceResponseDto getCustomerPreference(Long customerId) {

	    Customer customer = customerRepository.findById(customerId)
	            .orElseThrow(() -> new RuntimeException("Customer not found"));

	    CustomerPreference preference = customer.getCustomerPreference();

	    if (preference == null) {
	        throw new RuntimeException("Customer preferences not found.");
	    }
	    String preferenceId = "PREF" + String.format("%06d", preference.getPreferenceId());

	    return new CustomerPreferenceResponseDto(
	    		    preferenceId,
	    	        preference.getLanguage(),
	    	        preference.getCommunicationMode(),
	    	        preference.getEmailEnabled(),
	    	        preference.getSmsEnabled(),
	    	        preference.getMarketingEnabled()
	    );
	}
	
	public CustomerPreference createPreference(Long customerId,
            CustomerPreference preference) {

           Customer customer = customerRepository.findById(customerId)
                 .orElseThrow(() -> new RuntimeException("Customer not found"));

                  preference.setCustomer(customer);

                   customer.setCustomerPreference(preference);

                     customerRepository.save(customer);

              return customer.getCustomerPreference();
}


	public void updateCustomer(Long customerId, CustomerRequestDto requestDto) {
		Customer customer = customerRepository.findById(customerId)
	            .orElseThrow(() -> new RuntimeException("Customer not found"));

	    customer.setOccupation(requestDto.getOccupation());
	    customer.setAnnalIncome(requestDto.getAnnualIncome());
	    customer.setMaritalStatus(requestDto.getMaritalStatus());

	    customerRepository.save(customer);
	}


	
	
}

