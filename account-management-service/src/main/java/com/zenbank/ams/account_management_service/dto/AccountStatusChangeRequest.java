package com.zenbank.ams.account_management_service.dto;

import jakarta.validation.constraints.NotBlank;

public class AccountStatusChangeRequest {

    @NotBlank(message = "Reason is required")
    private  String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}