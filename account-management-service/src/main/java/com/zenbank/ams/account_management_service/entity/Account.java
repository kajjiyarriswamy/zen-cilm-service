package com.zenbank.ams.account_management_service.entity;

import java.time.LocalDate;
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
	@SequenceGenerator(name="bank",sequenceName ="accountid",initialValue =1000,allocationSize = 1 )
	@GeneratedValue(generator = "bank",strategy = GenerationType.SEQUENCE)
	private Long accountId;
	@Column(name = "customer_id", unique = true, nullable = false, updatable = false, length = 20)
	private String customerId;
	
	@Column(name = "account_number", unique = true, nullable = false, updatable = false, length = 20)
	private String accountNumber;
	
	@Column(name = "account_type", nullable = false, updatable = false,length = 20)
	private String accountType;
	@Column(name = "branch_code", nullable = false, updatable = false,length = 20)
	private String branchCode;
	@Column(name = "ifsc_code", nullable = false, updatable = false, length = 20)
	private String ifscCode;
	@Column(name = "currency", nullable = false, updatable = false,length = 20)
	private String currency;
	@Column(name = "opening_balance", nullable = false, updatable = false)
	private Double openingBalance;
	@Column(name = "initial_deposit", nullable = false, updatable = false)
	private Double initialDeposit;
	@Column(name = "available_balance", nullable = false, updatable = false)
	private Double availableBalance;
	@Column(name = "ledger_balance", nullable = false, updatable = false)
	private Double ledgerBalance;
	@Column(name = "account_status", nullable = false, updatable = false,length = 20)
	private String accountStatus;
	@Column(name = "opened_date", nullable = false)
	private LocalDate openedDate;
	@Column(name = "created_by", nullable = false, updatable = false,length = 20)
	private String createdBy;
	@Column(name = "created_date", nullable = false)
	private LocalDate createdDate;
	@Column(name = "updated_date", nullable = false)
	private LocalDate updatedDate;
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public Account(Long accountId, String customerId, String accountNumber, String accountType, String branchCode,
			String ifscCode, String currency, Double openingBalance, Double initialDeposit, Double availableBalance,
			Double ledgerBalance, String accountStatus, LocalDate openedDate, String createdBy, LocalDate createdDate,
			LocalDate updatedDate) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.branchCode = branchCode;
		this.ifscCode = ifscCode;
		this.currency = currency;
		this.openingBalance = openingBalance;
		this.initialDeposit = initialDeposit;
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




	public Double getOpeningBalance() {
		return openingBalance;
	}




	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
	}




	public Double getInitialDeposit() {
		return initialDeposit;
	}




	public void setInitialDeposit(Double initialDeposit) {
		this.initialDeposit = initialDeposit;
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




	public LocalDate getOpenedDate() {
		return openedDate;
	}




	public void setOpenedDate(LocalDate openedDate) {
		this.openedDate = openedDate;
	}




	public String getCreatedBy() {
		return createdBy;
	}




	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}




	public LocalDate getCreatedDate() {
		return createdDate;
	}




	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}




	public LocalDate getUpdatedDate() {
		return updatedDate;
	}




	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}




	
	
	
}
	

	