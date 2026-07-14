package com.zenbank.cilm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenbank.cilm.dto.CustomerKycRejectResponseDto;
import com.zenbank.cilm.dto.CustomerKycRequestDto;
import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerKyc;
import com.zenbank.cilm.repository.CustomerKycRepository;
import com.zenbank.cilm.repository.CustomerRepository;

@Service
public class CustomerKycRejectServiceImpl implements CustomerKycRejectService {

    @Autowired
    private CustomerKycRepository customerKycRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public CustomerKycRejectResponseDto rejectKyc(Long customerId, CustomerKycRequestDto requestDto) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        
        CustomerKyc customerKyc = customerKycRepository.findByCustomer(customer)
                .orElseThrow(() -> new RuntimeException("Customer KYC not found"));

        CustomerKycRejectResponseDto response = new CustomerKycRejectResponseDto();
        // Check PAN verification
        if (Boolean.FALSE.equals(customerKyc.getPanVerified())) {

            customerKyc.setKycStatus("REJECTED");
            customerKycRepository.save(customerKyc);

            response.setStatus("SUCCESS");
            response.setMessage("KYC rejected successfully because PAN is not verified.");
            response.setKycStatus("REJECTED");

            return response;
        }
//		return response;

        throw new RuntimeException("KYC cannot be rejected because PAN is already verified.");
    }
	

	
}