package com.zenbank.ams.account_management_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountChequeBookResponseDto {

    private String status;
    private String message;
    private String chequeBookRequestId;
    private String requestStatus;

    private DataResponse data;

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

    public DataResponse getData() {return data;}
    public void setData(DataResponse data) {this.data = data;}

    public static class  DataResponse {
        private String chequeBookRequestId;
        private String accountNumber;
        private String chequeBookType;
        private Integer leavesCount;
        private String requestMode;
        private String deliveryMode;
        private String requestStatus;
        private String trackingNumber;
        private LocalDate dispatchedDate;
        private LocalDate deliveredDate;

        public String getChequeBookRequestId() {
            return chequeBookRequestId;
        }

        public void setChequeBookRequestId(String chequeBookRequestId) {
            this.chequeBookRequestId = chequeBookRequestId;
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

        public String getRequestStatus() {
            return requestStatus;
        }

        public void setRequestStatus(String requestStatus) {
            this.requestStatus = requestStatus;
        }

        public String getTrackingNumber() {
            return trackingNumber;
        }

        public void setTrackingNumber(String trackingNumber) {
            this.trackingNumber = trackingNumber;
        }

        public LocalDate getDispatchedDate() {
            return dispatchedDate;
        }

        public void setDispatchedDate(LocalDate dispatchedDate) {
            this.dispatchedDate = dispatchedDate;
        }

        public LocalDate getDeliveredDate() {
            return this.deliveredDate;
        }

        public void setDeliveredDate(LocalDate deliveredDate) {
            this.deliveredDate = deliveredDate;
        }
    }
}
