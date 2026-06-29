package com.zenbank.cilm.service;

import com.zenbank.cilm.dto.CustomerRequestDto;
import com.zenbank.cilm.dto.CustomerResponseDto;
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

    public CustomerResponseDto createCustomer(CustomerRequestDto requestDto) {
        Optional<Customer> existing = customerRepository.findByEmail(requestDto.getEmail());
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Customer with this email already exists");
        }

        Customer customer = new Customer(
                requestDto.getFirstName(),
                requestDto.getLastName(),
                requestDto.getEmail(),
                requestDto.getPhoneNumber(),
                requestDto.getAccountNumber()
        );

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
}
