package com.zenbank.cilm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenbank.cilm.Enum.PreferredContactMode;
import com.zenbank.cilm.dto.CommonResponseDto;
import com.zenbank.cilm.dto.PreferredContactModeRequestDto;
import com.zenbank.cilm.entity.CustomerAudit;
import com.zenbank.cilm.entity.CustomerContact;
import com.zenbank.cilm.repository.CustomerAuditRepository;
import com.zenbank.cilm.repository.CustomerContactRepository;


@Service
public class CustomerContactService {


    @Autowired
    private CustomerContactRepository contactRepository;


    @Autowired
    private CustomerAuditRepository auditRepository;



    public CommonResponseDto updatePreferredMode(
            String customerId,
            PreferredContactModeRequestDto request) {

        CustomerContact contact = contactRepository
                .findByCustomer_CustomerId(customerId)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found"));

        PreferredContactMode mode;

        try {
            mode = PreferredContactMode.valueOf(
                    request.getPreferredContactMode().toUpperCase());
        } catch (Exception e) {
            return new CommonResponseDto(
                    "FAILED",
                    "Invalid communication mode.",
                    "CNT_005");
        }

        String oldValue = contact.getPreferredContactMode().toString();

        contact.setPreferredContactMode(mode);
        contactRepository.save(contact);

        CustomerAudit audit = new CustomerAudit();
        audit.setCustomer(contact.getCustomer());
        audit.setAction("PREFERRED_CONTACT_MODE_UPDATED");
        audit.setPerformedBy("BANK_EMPLOYEE");
        audit.setOldValue(oldValue);
        audit.setNewValue(mode.toString());

        auditRepository.save(audit);

        return new CommonResponseDto(
                "SUCCESS",
                "Preferred contact mode updated successfully.",
                null);
    }
    }