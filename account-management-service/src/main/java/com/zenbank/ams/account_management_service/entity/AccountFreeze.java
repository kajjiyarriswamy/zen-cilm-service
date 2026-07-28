package com.zenbank.ams.account_management_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "account_freeze")
public class AccountFreeze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "freeze_id")
    private Long freezeId;

    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "freeze_type", nullable = false)
    private String freezeType;

    @Column(name = "reason")
    private String reason;

    @Column(name = "status")
    private String status;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public AccountFreeze() {
    }

    public AccountFreeze(Long freezeId, Long accountId, String freezeType,
                         String reason, String status, LocalDateTime createdDate) {
        this.freezeId = freezeId;
        this.accountId = accountId;
        this.freezeType = freezeType;
        this.reason = reason;
        this.status = status;
        this.createdDate = createdDate;
    }

    public Long getFreezeId() {
        return freezeId;
    }

    public void setFreezeId(Long freezeId) {
        this.freezeId = freezeId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getFreezeType() {
        return freezeType;
    }

    public void setFreezeType(String freezeType) {
        this.freezeType = freezeType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
