package com.zenbank.deposit_service.dto;

public class CreateDepositRequest {

    private String customerId;
    private Long accountId;
    private String depositTypeCode;
    private String depositChannelCode;
    private Double amount;
    private String currency;
    private String branchCode;
    private String branchName;
    private String remarks;

    public CreateDepositRequest() {
    }

    public CreateDepositRequest(String customerId, Long accountId, String depositTypeCode, String depositChannelCode,
                                Double amount, String currency, String branchCode, String branchName, String remarks) {
        this.customerId = customerId;
        this.accountId = accountId;
        this.depositTypeCode = depositTypeCode;
        this.depositChannelCode = depositChannelCode;
        this.amount = amount;
        this.currency = currency;
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.remarks = remarks;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getDepositTypeCode() {
        return depositTypeCode;
    }

    public void setDepositTypeCode(String depositTypeCode) {
        this.depositTypeCode = depositTypeCode;
    }

    public String getDepositChannelCode() {
        return depositChannelCode;
    }

    public void setDepositChannelCode(String depositChannelCode) {
        this.depositChannelCode = depositChannelCode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
