package com.zenbank.cilm.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zenbank.cilm.dto.CustomerNomineeRequestDto;
import com.zenbank.cilm.dto.CustomerNomineeResponseDto;
import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerKyc;
import com.zenbank.cilm.entity.CustomerNominee;
import com.zenbank.cilm.repository.CustomerKycRepository;
import com.zenbank.cilm.repository.CustomerNomineeRepository;
import com.zenbank.cilm.repository.CustomerRepository;

@Service
public class CustomerNomineeService {
    private final CustomerRepository customerRepository;
    private final CustomerNomineeRepository customerNomineeRepository;
    private final CustomerKycRepository customerKycRepository;

    public CustomerNomineeService(CustomerRepository customerRepository,
                                  CustomerNomineeRepository customerNomineeRepository,
                                  CustomerKycRepository customerKycRepository) {
        this.customerRepository = customerRepository;
        this.customerNomineeRepository = customerNomineeRepository;
        this.customerKycRepository = customerKycRepository;
    }

    public CustomerNomineeResponseDto addNominee(String customerId,
                                                 CustomerNomineeRequestDto requestDto) {

        Customer customer = customerRepository.findByCustomerId(customerId)
                .orElseThrow(() ->
                        new IllegalArgumentException("Customer not found."));

        CustomerKyc customerKyc = customerKycRepository.findByCustomer(customer)
                .orElseThrow(() ->
                        new IllegalArgumentException("Customer KYC not found."));

        if (!"VERIFIED".equalsIgnoreCase(customerKyc.getKycStatus())) {
            throw new IllegalArgumentException("Customer KYC must be VERIFIED.");
        }

        if (requestDto.getNomineeName() == null ||
                requestDto.getNomineeName().trim().isEmpty()) {
            throw new IllegalArgumentException("Nominee name is mandatory.");
        }

        if (requestDto.getSharePercentage() <= 0) {
            throw new IllegalArgumentException("Share percentage must be greater than 0.");
        }

        if (!requestDto.getMobile().matches("\\d{10}")) {
            throw new IllegalArgumentException("Mobile number must contain 10 digits.");
        }

        if (requestDto.getDob().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth cannot be a future date.");
        }

        List<CustomerNominee> nominees =
                customerNomineeRepository.findByCustomer(customer);

        double totalShare = nominees.stream()
                .mapToDouble(CustomerNominee::getSharePercentage)
                .sum();

        if (totalShare + requestDto.getSharePercentage() > 100) {
            throw new IllegalArgumentException(
                    "Total nominee share percentage cannot exceed 100%.");
        }

        CustomerNominee nominee = new CustomerNominee();

        nominee.setCustomer(customer);
        nominee.setNomineeName(requestDto.getNomineeName());
        nominee.setRelationship(requestDto.getRelationship());
        nominee.setDob(requestDto.getDob());
        nominee.setMobile(requestDto.getMobile());
        nominee.setSharePercentage(requestDto.getSharePercentage());
        nominee.setVerificationStatus("PENDING");

        CustomerNominee saved = customerNomineeRepository.save(nominee);

        return new CustomerNomineeResponseDto(
                "SUCCESS",
                "Nominee added successfully.",
                "NOM" + String.format("%06d", saved.getNomineeId()),
                saved.getVerificationStatus());
    }
}

