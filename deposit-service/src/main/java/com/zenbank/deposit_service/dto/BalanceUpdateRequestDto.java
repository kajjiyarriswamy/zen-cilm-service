package com.zenbank.deposit_service.dto;

public class BalanceUpdateRequestDto {

    private Double amount;

    public BalanceUpdateRequestDto() {
    }

    public BalanceUpdateRequestDto(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
