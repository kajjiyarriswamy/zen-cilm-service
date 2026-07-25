package com.zenbank.deposit_service.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "deposit_audit")
public class DepositAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_id")
    private Long auditId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deposit_id", nullable = false)
    private DepositTransaction depositTransaction;

//    @Column(name = "deposit_id")
//    private Long depositId;

    @Column(name = "action", nullable = false, length = 50)
    private String action;

    @Column(name = "performed_by", nullable = false, length = 50)
    private String performedBy;

    @Column(name = "old_value",  nullable = false)
    private String oldValue;

    @Column(name = "new_value",   nullable = false)
    private String newValue;

    @Column(name = "ip_address",  nullable = false, length = 50)
    private String ipAddress;

    @Column(name = "device_info",   nullable = false, length = 200)
    private String deviceInfo;

    @Column(name = "audit_status", nullable = false, length = 20)
    private String auditStatus;

    @Column(name = "created_date")
    private LocalDate createdDate;

    public DepositAudit() {
    }

    public DepositAudit(Long auditId, DepositTransaction depositTransaction, String action, String performedBy, String oldValue, String newValue, String ipAddress, String deviceInfo, String auditStatus, LocalDate createdDate) {
        this.auditId = auditId;
        this.depositTransaction = depositTransaction;
        this.action = action;
        this.performedBy = performedBy;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.ipAddress = ipAddress;
        this.deviceInfo = deviceInfo;
        this.auditStatus = auditStatus;
        this.createdDate = createdDate;
    }

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public DepositTransaction getDepositTransaction() {
        return depositTransaction;
    }

    public void setDepositTransaction(DepositTransaction depositTransaction) {
        this.depositTransaction = depositTransaction;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
