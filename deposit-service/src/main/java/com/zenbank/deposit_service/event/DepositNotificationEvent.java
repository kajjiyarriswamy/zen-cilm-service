package com.zenbank.deposit_service.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DepositNotificationEvent {

    private Long accountId;
    private Long customerId;
    private BigDecimal amount;
    private String currency;
    private String transactionReference;
    private LocalDateTime transactionDate;

    public DepositNotificationEvent() {
    }

    public DepositNotificationEvent(Long accountId, Long customerId, BigDecimal amount, String currency,
                                    String transactionReference, LocalDateTime transactionDate) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.amount = amount;
        this.currency = currency;
        this.transactionReference = transactionReference;
        this.transactionDate = transactionDate;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
