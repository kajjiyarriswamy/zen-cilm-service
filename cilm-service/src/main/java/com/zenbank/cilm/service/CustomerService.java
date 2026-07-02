package com.zenbank.cilm.service;

import com.zenbank.cilm.dto.*;
import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerAddress;
import com.zenbank.cilm.repository.AddressRepository;
import com.zenbank.cilm.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    private AddressRepository customerAddressRepository;

    public CustomerResponseDto createCustomer(CustomerGetRequestDto requestDto) {
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
        customer.setAnnalIncome(requestDto.getAnnalIncome());
        customer.setCustomerType(requestDto.getCustomerType());
        customer.setCustomerCategory(requestDto.getCustomerCategory());
        customer.setEmail(requestDto.getEmail());
        customer.setPhoneNumber(requestDto.getPhoneNumber());
        customer.setAadhaarNumber(requestDto.getAadhaarNumber());
        customer.setPanNumber(requestDto.getPanNumber());
        customer.setNationality(requestDto.getNationality());
        customer.setAccountNumber("SBI-"+String.valueOf(10000000+random.nextInt(90000000)));
        customer.setCreatedDate(LocalDate.now());
        customer.setCustomerStatus(requestDto.getCustomerStatus());
        customer.setRiskCategory(requestDto.getRiskCategory());

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

    public AddressResponseDto addAddress(Long customerId, AddressRequestDto requestDto) {
        Customer customer =  customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new RuntimeException("customer not found"));

        if (requestDto.getCountry() == null || requestDto.getCountry().isBlank()) {
            throw new RuntimeException("Country cannot be null");
        }

        if (!requestDto.getPostalCode().matches("\\d{6}")) {
            throw new RuntimeException("Invalid Postal Code");
        }

        if (Boolean.TRUE.equals(requestDto.getIsPrimary())) {

            boolean exists = customerAddressRepository
                    .existsByCustomerAndIsPrimaryTrue(customer);

            if (exists) {
                throw new RuntimeException("Primary Address already exists");
            }
        }


        CustomerAddress customerAddress = new CustomerAddress();
        customerAddress.setCustomer(customer);
        customerAddress.setAddressType(requestDto.getAddressType());
        customerAddress.setDoorNumber(requestDto.getDoorNumber());
        customerAddress.setStreet(requestDto.getStreet());
        customerAddress.setArea(requestDto.getArea());
        customerAddress.setCity(requestDto.getCity());
        customerAddress.setDistrict(requestDto.getDistrict());
        customerAddress.setState(requestDto.getState());
        customerAddress.setCountry(requestDto.getCountry());
        customerAddress.setPostalCode(requestDto.getPostalCode());
        customerAddress.setPrimary(requestDto.getIsPrimary());

        customerAddressRepository.save(customerAddress);

        AddressResponseDto response = new AddressResponseDto();
        response.setStatus("SUCCESS");
        response.setMessage("Customer address added successfully.");
        response.setAddressId(customerAddress.getAddressId());
        response.setCustomerId(customer.getId());

        return response;
    }

}
