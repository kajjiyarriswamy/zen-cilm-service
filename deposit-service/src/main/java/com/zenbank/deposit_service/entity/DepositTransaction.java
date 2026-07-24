package com.zenbank.deposit_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "deposit_transaction")
public class DepositTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deposit_id")
    private Long depositId;

    @Column(name = "transaction_reference", unique = true, nullable = false, length = 50)
    private String transactionReference;

    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "customer_id", nullable = false, length = 20)
    private String customerId;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "currency", nullable = false, length = 10)
    private String currency;

    @Column(name = "deposit_type", nullable = false, length = 20)
    private String depositType;

    @Column(name = "deposit_channel", nullable = false, length = 20)
    private String depositChannel;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "branch_code", length = 20)
    private String branchCode;

    @Column(name = "branch_name", length = 100)
    private String branchName;

    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    public DepositTransaction() {
    }

    public DepositTransaction(String transactionReference, Long accountId, String customerId, Double amount,
                              String currency, String depositType, String depositChannel, String status,
                              String remarks, String branchCode, String branchName, LocalDateTime transactionDate) {
        this.transactionReference = transactionReference;
        this.accountId = accountId;
        this.customerId = customerId;
        this.amount = amount;
        this.currency = currency;
        this.depositType = depositType;
        this.depositChannel = depositChannel;
        this.status = status;
        this.remarks = remarks;
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.transactionDate = transactionDate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
