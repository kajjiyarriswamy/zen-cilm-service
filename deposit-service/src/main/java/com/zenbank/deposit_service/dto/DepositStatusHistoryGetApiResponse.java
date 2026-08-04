package com.zenbank.deposit_service.dto;

import java.util.List;

public class DepositStatusHistoryGetApiResponse {

    private String status;
    private String message;
    private List<DepositStatusHistoryResponse> data;

    public DepositStatusHistoryGetApiResponse() {
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

    public List<DepositStatusHistoryResponse> getData() {
        return data;
    }

    public void setData(List<DepositStatusHistoryResponse> data) {
        this.data = data;
    }
}
