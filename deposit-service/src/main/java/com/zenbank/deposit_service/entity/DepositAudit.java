package com.zenbank.deposit_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "deposit_audit")
public class DepositAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_id")
    private Long auditId;

    @Column(name = "action", nullable = false, length = 50)
    private String action;

    @Column(name = "customer_id", nullable = false, length = 20)
    private String customerId;

    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "performed_by", nullable = false, length = 50)
    private String performedBy;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    public DepositAudit() {
    }

    public DepositAudit(String action, String customerId, Long accountId, Double amount, String performedBy,
                        String status, LocalDateTime createdDate) {
        this.action = action;
        this.customerId = customerId;
        this.accountId = accountId;
        this.amount = amount;
        this.performedBy = performedBy;
        this.status = status;
        this.createdDate = createdDate;
    }

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
