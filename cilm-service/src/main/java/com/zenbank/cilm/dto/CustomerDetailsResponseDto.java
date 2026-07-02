package com.zenbank.cilm.dto;

import com.zenbank.cilm.entity.Customer;

public class CustomerDetailsResponseDto {

    private String customerId;
    private String cifNumber;
    private String customerName;
    private String mobile;
    private String email;
    private String status;

    public CustomerDetailsResponseDto() {
    }

    public CustomerDetailsResponseDto(String customerId, String cifNumber,
                                      String customerName, String mobile,
                                      String email, String status) {
        this.customerId = customerId;
        this.cifNumber = cifNumber;
        this.customerName = customerName;
        this.mobile = mobile;
        this.email = email;
        this.status = status;
    }

    public static CustomerDetailsResponseDto fromEntity(Customer customer) {
        String fullName = customer.getFirstName() + " "
                + customer.getMiddleName() + " "
                + customer.getLastName();
        return new CustomerDetailsResponseDto(
                customer.getCustomerId(),
                customer.getCif_number(),
                fullName.trim(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                customer.getCustomerStatus()
        );
    }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getCifNumber() { return cifNumber; }
    public void setCifNumber(String cifNumber) { this.cifNumber = cifNumber; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}