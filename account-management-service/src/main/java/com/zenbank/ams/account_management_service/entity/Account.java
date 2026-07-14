package com.zenbank.ams.account_management_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="account")
public class Account {
	@Id
	//@SequenceGenerator(name="bank",sequenceName ="accountid",initialValue =1000,allocationSize = 1 )
	@GeneratedValue(generator = "bank",strategy = GenerationType.IDENTITY)
	private Long accountId;
	@Column(name = "customer_id", unique = true, nullable = false, updatable = false, length = 20)
	private String customerId;
	
	@Column(name = "account_number", unique = true, nullable = false, updatable = false, length = 20)
	private String accountNumber;
	
	@Column(name = "account_type", nullable = false, updatable = false,length = 20)
	private String accountType;
	@Column(name = "branch_code", nullable = false, updatable = false,length = 20)
	private String branchCode;
	@Column(name = "ifsc_code", unique = true, nullable = false, updatable = false, length = 20)
	private String ifscCode;
	@Column(name = "currency", nullable = false, updatable = false,length = 20)
	private String currency;
	@Column(name = "opening_balance", nullable = false, updatable = false)
	private double openingBalance;
	@Column(name = "available_balance", nullable = false, updatable = false)
	private double availableBalance;
	@Column(name = "ledger_balance", nullable = false, updatable = false)
	private double ledgerBalance;
	@Column(name = "account_status", nullable = false, updatable = false,length = 20)
	private String accountStatus;
	@Column(name = "opened_date", nullable = false)
	private LocalDateTime openedDate;
	@Column(name = "created_by", nullable = false, updatable = false,length = 20)
	private String createdBy;
	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;
	@Column(name = "updated_date", nullable = false)
	private LocalDateTime updatedDate;
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(Long accountId, String customerId, String accountNumber, String accountType, String branchCode,
			String ifscCode, String currency, double openingBalance, double availableBalance, double ledgerBalance,
			String accountStatus, LocalDateTime openedDate, String createdBy, LocalDateTime createdDate,
			LocalDateTime updatedDate) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.branchCode = branchCode;
		this.ifscCode = ifscCode;
		this.currency = currency;
		this.openingBalance = openingBalance;
		this.availableBalance = availableBalance;
		this.ledgerBalance = ledgerBalance;
		this.accountStatus = accountStatus;
		this.openedDate = openedDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
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
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}
	public double getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}
	public double getLedgerBalance() {
		return ledgerBalance;
	}
	public void setLedgerBalance(double ledgerBalance) {
		this.ledgerBalance = ledgerBalance;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public LocalDateTime getOpenedDate() {
		return openedDate;
	}
	public void setOpenedDate(LocalDateTime openedDate) {
		this.openedDate = openedDate;
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
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	

}
