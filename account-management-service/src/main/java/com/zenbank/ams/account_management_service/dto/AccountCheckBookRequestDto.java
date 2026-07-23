package com.zenbank.ams.account_management_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AccountCheckBookRequestDto {

    @NotBlank(message = "Customer ID is required")
    private String customerId;

    @NotBlank(message = "Account number is required")
    private String accountNumber;

    @NotBlank(message = "Cheque book type is required")
    private String chequeBookType;

    @NotNull(message = "Leaves count is required")
    private Integer leavesCount;

    @NotBlank(message = "Request mode is required")
    private String requestMode;

    @NotBlank(message = "Delivery mode is required")
    private String deliveryMode;

    @Valid
    @NotNull(message = "Delivery address is required")
    private DeliveryAddressDto deliveryAddress;

    public AccountCheckBookRequestDto() {
        super();
    }

    public AccountCheckBookRequestDto(String customerId, String accountNumber, String chequeBookType,
            Integer leavesCount, String requestMode, String deliveryMode, DeliveryAddressDto deliveryAddress) {
        super();
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.chequeBookType = chequeBookType;
        this.leavesCount = leavesCount;
        this.requestMode = requestMode;
        this.deliveryMode = deliveryMode;
        this.deliveryAddress = deliveryAddress;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getChequeBookType() {
        return chequeBookType;
    }

    public void setChequeBookType(String chequeBookType) {
        this.chequeBookType = chequeBookType;
    }

    public Integer getLeavesCount() {
        return leavesCount;
    }

    public void setLeavesCount(Integer leavesCount) {
        this.leavesCount = leavesCount;
    }

    public String getRequestMode() {
        return requestMode;
    }

    public void setRequestMode(String requestMode) {
        this.requestMode = requestMode;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public DeliveryAddressDto getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddressDto deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public static class DeliveryAddressDto {

        @NotBlank(message = "Door number is required")
        private String doorNumber;

        @NotBlank(message = "Street is required")
        private String street;

        @NotBlank(message = "Area is required")
        private String area;

        @NotBlank(message = "City is required")
        private String city;

        @NotBlank(message = "State is required")
        private String state;

        @NotBlank(message = "Postal code is required")
        private String postalCode;

        @NotBlank(message = "Country is required")
        private String country;

        public DeliveryAddressDto() {
            super();
        }

        public DeliveryAddressDto(String doorNumber, String street, String area, String city, String state,
                String postalCode, String country) {
            super();
            this.doorNumber = doorNumber;
            this.street = street;
            this.area = area;
            this.city = city;
            this.state = state;
            this.postalCode = postalCode;
            this.country = country;
        }

        public String getDoorNumber() {
            return doorNumber;
        }

        public void setDoorNumber(String doorNumber) {
            this.doorNumber = doorNumber;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }


}
