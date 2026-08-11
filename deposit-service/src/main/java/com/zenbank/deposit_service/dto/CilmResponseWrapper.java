package com.zenbank.deposit_service.dto;

public class CilmResponseWrapper {

    private String success;
    private CustomerDetailsResponseDto data;

    public CilmResponseWrapper() {
    }

    public CilmResponseWrapper(String success, CustomerDetailsResponseDto data) {
        this.success = success;
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public CustomerDetailsResponseDto getData() {
        return data;
    }

    public void setData(CustomerDetailsResponseDto data) {
        this.data = data;
    }
}
