package com.zenbank.cilm.dto;

import com.zenbank.cilm.entity.CustomerAddress;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

public class AddressResponseDto {

    private String status;

    private String message;

    private Long addressId;

    private Long customerId;

    public AddressResponseDto() {
    }

    public AddressResponseDto(String status, String message, Long addressId, Long customerId) {
        this.status = status;
        this.message = message;
        this.addressId = addressId;
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
