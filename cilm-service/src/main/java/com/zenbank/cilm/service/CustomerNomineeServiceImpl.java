package com.zenbank.cilm.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zenbank.cilm.dto.CustomerNomineeRequestDto;
import com.zenbank.cilm.dto.CustomerNomineeResponseDto;
import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerAudit;
import com.zenbank.cilm.entity.CustomerKyc;
import com.zenbank.cilm.entity.CustomerNominee;
import com.zenbank.cilm.repository.CustomerAuditRepository;
import com.zenbank.cilm.repository.CustomerKycRepository;
import com.zenbank.cilm.repository.CustomerNomineeRepository;
import com.zenbank.cilm.repository.CustomerRepository;
@Service

public class CustomerNomineeServiceImpl implements CustomerNomineeService {

    private final CustomerRepository customerRepository;
    private final CustomerNomineeRepository customerNomineeRepository;
    private final CustomerKycRepository customerKycRepository;
    private final CustomerAuditRepository customerAuditRepository;

    public CustomerNomineeServiceImpl(
            CustomerRepository customerRepository,
            CustomerNomineeRepository customerNomineeRepository,
            CustomerKycRepository customerKycRepository,
            CustomerAuditRepository customerAuditRepository) {

        this.customerRepository = customerRepository;
        this.customerNomineeRepository = customerNomineeRepository;
        this.customerKycRepository = customerKycRepository;
        this.customerAuditRepository = customerAuditRepository;
    }

    @Override
    public CustomerNomineeResponseDto addNominee(
            String customerId,
            CustomerNomineeRequestDto requestDto) {

        // Validate Customer
        Customer customer = customerRepository.findByCustomerId(customerId)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found"));

        // Validate KYC
        CustomerKyc customerKyc = customerKycRepository.findByCustomer(customer)
                .orElseThrow(() ->
                        new RuntimeException("Customer KYC not found"));

        if (!"VERIFIED".equalsIgnoreCase(customerKyc.getKycStatus())) {
            throw new RuntimeException("Customer KYC must be VERIFIED.");
        }

        // Validate Nominee Name
        if (requestDto.getNomineeName() == null ||
                requestDto.getNomineeName().trim().isEmpty()) {

            throw new RuntimeException("Nominee name is mandatory.");
        }

        // Validate Mobile
        if (requestDto.getMobile() == null ||
                !requestDto.getMobile().matches("\\d{10}")) {

            throw new RuntimeException(
                    "Mobile number must contain 10 digits.");
        }

        // Validate DOB
        if (requestDto.getDob().isAfter(LocalDate.now())) {

            throw new RuntimeException(
                    "Date of Birth cannot be a future date.");
        }

        // Validate Share Percentage
        if (requestDto.getSharePercentage() <= 0) {

            throw new RuntimeException(
                    "Share percentage must be greater than 0.");
        }

        // Existing Nominee Share
        List<CustomerNominee> nomineeList =
                customerNomineeRepository.findByCustomerId(customer);

        double totalShare = nomineeList.stream()
                .mapToDouble(CustomerNominee::getSharePercentage)
                .sum();

        if (totalShare + requestDto.getSharePercentage() > 100) {

            throw new RuntimeException(
                    "Total nominee share percentage cannot exceed 100%.");
        }

        CustomerNominee nominee = new CustomerNominee();

        nominee.setCustomerId(customer);
        nominee.setNomineeName(requestDto.getNomineeName());
        nominee.setRelationship(requestDto.getRelationship());
        nominee.setDob(requestDto.getDob());
        nominee.setMobile(requestDto.getMobile());
        nominee.setSharePercentage(requestDto.getSharePercentage());

        nominee.setVerificationStatus("PENDING");

        CustomerNominee savedNominee =
                customerNomineeRepository.save(nominee);
        // Create Audit Record
        CustomerAudit audit = new CustomerAudit();

        audit.setCustomer(customer);
        audit.setAction("ADD_NOMINEE");
        audit.setPerformedBy("SYSTEM"); // Replace with logged-in user if available
        audit.setOldValue(null);
        audit.setNewValue(
                "Nominee Name : " + savedNominee.getNomineeName()
                + ", Relationship : " + savedNominee.getRelationship()
                + ", Mobile : " + savedNominee.getMobile()
                + ", Share Percentage : " + savedNominee.getSharePercentage()
                + ", Verification Status : " + savedNominee.getVerificationStatus()
        );

        customerAuditRepository.save(audit);

        // Prepare Response
        CustomerNomineeResponseDto response =
                new CustomerNomineeResponseDto();

        response.setNomineeId(
                "NOM" + String.format("%06d",
                        savedNominee.getNomineeId()));

        response.setVerificationStatus(
                savedNominee.getVerificationStatus());

        return response;
    }

}