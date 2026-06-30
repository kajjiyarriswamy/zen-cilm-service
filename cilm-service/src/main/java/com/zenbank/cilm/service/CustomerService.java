package com.zenbank.cilm.service;

import com.zenbank.cilm.dto.CustomerRequestDto;
import com.zenbank.cilm.dto.CustomerResponseDto;
import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

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

        log.info(
                savedCustomer.toString()
        );
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
