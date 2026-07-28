package com.zenbank.deposit_service.entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "cash_deposit")
public class CashDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cash_deposit_id")
    private Long cashDepositId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deposit_id", nullable = false)
    private DepositTransaction depositTransaction;

    @Column(name = "total_amount", precision = 18, scale = 2, nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "denomination_2000")
    private Integer denomination2000;

    @Column(name = "denomination_500")
    private Integer denomination500;

    @Column(name = "denomination_200")
    private Integer denomination200;

    @Column(name = "denomination_100")
    private Integer denomination100;

    @Column(name = "denomination_50")
    private Integer denomination50;

    @Column(name = "denomination_20")
    private Integer denomination20;

    @Column(name = "denomination_10")
    private Integer denomination10;

    @Column(name = "total_notes")
    private Integer totalNotes;

    @Column(name = "cashier_id", length = 30)
    private String cashierId;

    @Column(name = "cashier_name", length = 100)
    private String cashierName;

    @Column(name = "branch_code", length = 20)
    private String branchCode;

    @Column(name = "branch_name", length = 100)
    private String branchName;

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

    public CashDeposit() {
    }

    @PrePersist
    public void onCreate() {
        this.createdDate = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }

    public Long getCashDepositId() {
        return cashDepositId;
    }

    public void setCashDepositId(Long cashDepositId) {
        this.cashDepositId = cashDepositId;
    }

    public DepositTransaction getDepositTransaction() {
        return depositTransaction;
    }

    public void setDepositTransaction(DepositTransaction depositTransaction) {
        this.depositTransaction = depositTransaction;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getDenomination2000() {
        return denomination2000;
    }

    public void setDenomination2000(Integer denomination2000) {
        this.denomination2000 = denomination2000;
    }

    public Integer getDenomination500() {
        return denomination500;
    }

    public void setDenomination500(Integer denomination500) {
        this.denomination500 = denomination500;
    }

    public Integer getDenomination200() {
        return denomination200;
    }

    public void setDenomination200(Integer denomination200) {
        this.denomination200 = denomination200;
    }

    public Integer getDenomination100() {
        return denomination100;
    }

    public void setDenomination100(Integer denomination100) {
        this.denomination100 = denomination100;
    }

    public Integer getDenomination50() {
        return denomination50;
    }

    public void setDenomination50(Integer denomination50) {
        this.denomination50 = denomination50;
    }

    public Integer getDenomination20() {
        return denomination20;
    }

    public void setDenomination20(Integer denomination20) {
        this.denomination20 = denomination20;
    }

    public Integer getDenomination10() {
        return denomination10;
    }

    public void setDenomination10(Integer denomination10) {
        this.denomination10 = denomination10;
    }

    public Integer getTotalNotes() {
        return totalNotes;
    }

    public void setTotalNotes(Integer totalNotes) {
        this.totalNotes = totalNotes;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
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
}