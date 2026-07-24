package com.zenbank.deposit_service.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.zenbank.deposit_service.enums.ChequeStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cheque_deposit")
public class ChequeDeposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cheque_deposit_id")
    private Long chequeDepositId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deposit_id", nullable = false)
    private DepositTransaction depositTransaction;

    @Column(name = "cheque_number", length = 20, nullable = false)
    private String chequeNumber;

    @Column(name = "cheque_date", nullable = false)
    private LocalDate chequeDate;

    @Column(name = "cheque_amount", precision = 18, scale = 2, nullable = false)
    private BigDecimal chequeAmount;

    @Column(name = "issuing_bank", length = 100, nullable = false)
    private String issuingBank;

    @Column(name = "branch_name", length = 100)
    private String branchName;

    @Column(name = "ifsc_code", length = 15)
    private String ifscCode;

    @Column(name = "micr_code", length = 15)
    private String micrCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "cheque_status", length = 30)
    private ChequeStatus chequeStatus;

    @Column(name = "clearing_date")
    private LocalDate clearingDate;

    @Column(name = "remarks", length = 500)
    private String remarks;

    @Column(name = "created_by", length = 50)
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_by", length = 50)
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    public ChequeDeposit() {
    }

    public ChequeDeposit(Long chequeDepositId, DepositTransaction depositTransaction, String chequeNumber,
            LocalDate chequeDate, BigDecimal chequeAmount, String issuingBank, String branchName,
            String ifscCode, String micrCode, ChequeStatus chequeStatus, LocalDate clearingDate,
            String remarks, String createdBy, LocalDateTime createdDate,
            String updatedBy, LocalDateTime updatedDate) {
        this.chequeDepositId = chequeDepositId;
        this.depositTransaction = depositTransaction;
        this.chequeNumber = chequeNumber;
        this.chequeDate = chequeDate;
        this.chequeAmount = chequeAmount;
        this.issuingBank = issuingBank;
        this.branchName = branchName;
        this.ifscCode = ifscCode;
        this.micrCode = micrCode;
        this.chequeStatus = chequeStatus;
        this.clearingDate = clearingDate;
        this.remarks = remarks;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
    }

    public Long getChequeDepositId() {
        return chequeDepositId;
    }

    public void setChequeDepositId(Long chequeDepositId) {
        this.chequeDepositId = chequeDepositId;
    }

    public DepositTransaction getDepositTransaction() {
        return depositTransaction;
    }

    public void setDepositTransaction(DepositTransaction depositTransaction) {
        this.depositTransaction = depositTransaction;
    }

    public String getChequeNumber() {
        return chequeNumber;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    public LocalDate getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(LocalDate chequeDate) {
        this.chequeDate = chequeDate;
    }

    public BigDecimal getChequeAmount() {
        return chequeAmount;
    }

    public void setChequeAmount(BigDecimal chequeAmount) {
        this.chequeAmount = chequeAmount;
    }

    public String getIssuingBank() {
        return issuingBank;
    }

    public void setIssuingBank(String issuingBank) {
        this.issuingBank = issuingBank;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getMicrCode() {
        return micrCode;
    }

    public void setMicrCode(String micrCode) {
        this.micrCode = micrCode;
    }

    public ChequeStatus getChequeStatus() {
        return chequeStatus;
    }

    public void setChequeStatus(ChequeStatus chequeStatus) {
        this.chequeStatus = chequeStatus;
    }

    public LocalDate getClearingDate() {
        return clearingDate;
    }

    public void setClearingDate(LocalDate clearingDate) {
        this.clearingDate = clearingDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}


