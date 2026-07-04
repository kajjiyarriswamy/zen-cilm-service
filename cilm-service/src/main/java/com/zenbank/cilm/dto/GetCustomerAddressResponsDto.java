package com.zenbank.cilm.dto;

public class GetCustomerAddressResponsDto {

    private Long addressId;
    private String AddressType;
    private String DoorNumber;
    private String Street;
    private String City;
    private String State;
    private String country;
    private String postalCode;
    private Boolean primary;

    public GetCustomerAddressResponsDto() {
    }

    public GetCustomerAddressResponsDto(Long addressId, String addressType, String doorNumber, String street, String city, String state, String country, String postalCode, Boolean primary) {
        this.addressId = addressId;
        this.AddressType = addressType;
        this.DoorNumber = doorNumber;
        this.Street = street;
        this.City = city;
        this. State = state;
        this.country = country;
        this.postalCode = postalCode;
        this.primary = primary;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddressType() {
        return AddressType;
    }

    public void setAddressType(String addressType) {
        AddressType = addressType;
    }

    public String getDoorNumber() {
        return DoorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        DoorNumber = doorNumber;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }
}
