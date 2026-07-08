package com.zenbank.cilm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerContactResponseDto {

    private String status;
    private String message;
    private String contactId;
    private String customerId;

    public CustomerContactResponseDto() {
    }

    public CustomerContactResponseDto(String status, String message, String contactId, String customerId) {
        this.status = status;
        this.message = message;
        this.contactId = contactId;
        this.customerId = customerId;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getContactId() { return contactId; }
    public void setContactId(String contactId) { this.contactId = contactId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
}
