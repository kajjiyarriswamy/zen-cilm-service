package com.zenbank.ams.account_management_service.dto;

public class AccountDetailsResponseDto {

    private Long accountId;
    private String customerId;
    private String accountNumber;
    private String accountType;
    private String branchCode;
    private String currency;
    private Double availableBalance;
    private Double ledgerBalance;
    private String accountStatus;

    public AccountDetailsResponseDto() {
    }

    public AccountDetailsResponseDto(Long accountId, String customerId, String accountNumber, String accountType,
                                     String branchCode, String currency, Double availableBalance, Double ledgerBalance,
                                     String accountStatus) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.branchCode = branchCode;
        this.currency = currency;
        this.availableBalance = availableBalance;
        this.ledgerBalance = ledgerBalance;
        this.accountStatus = accountStatus;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Double getLedgerBalance() {
        return ledgerBalance;
    }

    public void setLedgerBalance(Double ledgerBalance) {
        this.ledgerBalance = ledgerBalance;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}
