package com.zenbank.ams.account_management_service.dto;

import java.math.BigDecimal;

public class AccountBalanceResponse {

    private String accountNumber;
    private BigDecimal availableBalance;
    private BigDecimal ledgerBalance;

    public AccountBalanceResponse() {
    }

    public AccountBalanceResponse(String accountNumber,
                                  BigDecimal availableBalance,
                                  BigDecimal ledgerBalance) {
        this.accountNumber = accountNumber;
        this.availableBalance = availableBalance;
        this.ledgerBalance = ledgerBalance;
    }

    public AccountBalanceResponse(Long accountId, Double availableBalance, Double ledgerBalance) {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public BigDecimal getLedgerBalance() {
        return ledgerBalance;
    }

    public void setLedgerBalance(BigDecimal ledgerBalance) {
        this.ledgerBalance = ledgerBalance;
    }
}