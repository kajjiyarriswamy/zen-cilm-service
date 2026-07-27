package com.zenbank.ams.account_management_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public class DebitCardUpdateRequest {

    @NotBlank(message = "Delivery mode is required")
    private String deliveryMode;

    @Valid
    private DispatchAddress dispatchAddress;

    private String remarks;

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public DispatchAddress getDispatchAddress() {
        return dispatchAddress;
    }

    public void setDispatchAddress(DispatchAddress dispatchAddress) {
        this.dispatchAddress = dispatchAddress;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

