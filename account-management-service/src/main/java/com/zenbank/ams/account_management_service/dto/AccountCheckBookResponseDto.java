package com.zenbank.ams.account_management_service.dto;

public class AccountCheckBookResponseDto {

    private String status;
    private String message;
    private String chequeBookRequestId;
    private String requestStatus;

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

    public String getChequeBookRequestId() {
        return chequeBookRequestId;
    }

    public void setChequeBookRequestId(String chequeBookRequestId) {
        this.chequeBookRequestId = chequeBookRequestId;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }
}
