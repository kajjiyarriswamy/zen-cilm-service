package com.zenbank.deposit_service.dto;

import java.time.LocalDateTime;

public class DepositResponse {

    private String status;
    private String message;
    private DepositData data;

    public DepositResponse() {
    }

    public DepositResponse(String status, String message, DepositData data) {
        this.status = status;
        this.message = message;
        this.data = data;
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

    public DepositData getData() {
        return data;
    }

    public void setData(DepositData data) {
        this.data = data;
    }

    public static class DepositData {
        private Long depositId;
        private String transactionReference;
        private Long accountId;
        private String customerId;
        private Double depositAmount;
        private String currency;
        private String depositType;
        private String depositChannel;
        private String transactionStatus;
        private String transactionDate; // formatted or LocalDateTime. 
        private Double availableBalance;

        public DepositData() {
        }

        public DepositData(Long depositId, String transactionReference, Long accountId, String customerId,
                           Double depositAmount, String currency, String depositType, String depositChannel,
                           String transactionStatus, String transactionDate, Double availableBalance) {
            this.depositId = depositId;
            this.transactionReference = transactionReference;
            this.accountId = accountId;
            this.customerId = customerId;
            this.depositAmount = depositAmount;
            this.currency = currency;
            this.depositType = depositType;
            this.depositChannel = depositChannel;
            this.transactionStatus = transactionStatus;
            this.transactionDate = transactionDate;
            this.availableBalance = availableBalance;
        }

        public Long getDepositId() {
            return depositId;
        }

        public void setDepositId(Long depositId) {
            this.depositId = depositId;
        }

        public String getTransactionReference() {
            return transactionReference;
        }

        public void setTransactionReference(String transactionReference) {
            this.transactionReference = transactionReference;
        }

        public Long getAccountId() {
            return accountId;
        }

        public void setAccountId(Long accountId) {
            this.accountId = accountId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Double getDepositAmount() {
            return depositAmount;
        }

        public void setDepositAmount(Double depositAmount) {
            this.depositAmount = depositAmount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getDepositType() {
            return depositType;
        }

        public void setDepositType(String depositType) {
            this.depositType = depositType;
        }

        public String getDepositChannel() {
            return depositChannel;
        }

        public void setDepositChannel(String depositChannel) {
            this.depositChannel = depositChannel;
        }

        public String getTransactionStatus() {
            return transactionStatus;
        }

        public void setTransactionStatus(String transactionStatus) {
            this.transactionStatus = transactionStatus;
        }

        public String getTransactionDate() {
            return transactionDate;
        }

        public void setTransactionDate(String transactionDate) {
            this.transactionDate = transactionDate;
        }

        public Double getAvailableBalance() {
            return availableBalance;
        }

        public void setAvailableBalance(Double availableBalance) {
            this.availableBalance = availableBalance;
        }
    }
}
