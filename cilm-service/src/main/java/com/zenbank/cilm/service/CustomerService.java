package com.zenbank.cilm.service;

import com.zenbank.cilm.dto.CustomerGetRequestDto;
import com.zenbank.cilm.dto.CustomerResponseDto;
import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.repository.CustomerRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponseDto createCustomer(CustomerGetRequestDto dto) {
        Optional<Customer> existing = customerRepository.findByEmail(dto.getEmail());
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Customer with this email already exists");
        }

        Customer cu = new Customer();
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
        		cu.setAge(dto.getAge());

        Customer savedCustomer = customerRepository.save(cu);
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
}
