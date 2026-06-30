package com.zenbank.cilm.service;

import com.zenbank.cilm.Enum.CustomerStatus;
import com.zenbank.cilm.dto.CustomerRequestDto;
import com.zenbank.cilm.dto.CustomerResponseDto;
import com.zenbank.cilm.dto.CustomerUpdateRequestDto;
import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponseDto createCustomer(CustomerUpdateRequestDto dto) {
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

	public void updateCustomerStatus(Long customerId, CustomerStatus status) {
		Customer customer = customerRepository.findById(customerId)
	            .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));

	    customer.setCustomerStatus(status);

	    customerRepository.save(customer);
	}
}