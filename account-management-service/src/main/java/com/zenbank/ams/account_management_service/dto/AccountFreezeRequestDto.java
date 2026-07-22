package com.zenbank.ams.account_management_service.dto;

import jakarta.validation.constraints.NotBlank;

public class AccountFreezeRequestDto {
	@NotBlank(message = "Reason is required")
    private String reason;

    public AccountFreezeRequestDto() {
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
