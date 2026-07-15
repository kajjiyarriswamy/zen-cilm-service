package com.zenbank.ams.account_management_service.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="account_limit")
public class AccountLimit {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long limitId;	

@ManyToOne
@JoinColumn(name="account_id")
private Account account;

@Column(name="account_id")
private Long accountId;

@Column(name="daily_atm_limit",precision=18,scale=2)
private BigDecimal dailyAtmLimit;

@Column(name="daily_upi_limit")
private BigDecimal dailyUpiLimit;

@Column(name="daily_neft_limit")
private BigDecimal dailyNeftLimit;

@Column(name="daily_rtgs_limit")
private BigDecimal dailyRtgsLimit;

@Column(name="daily_imps_limit")
private BigDecimal dailyImpsLimit;

@Column(name="monthly_transfer_limit")
private BigDecimal monthlyTransferLimit;

@Column(name="status", length=20)
private String status;

@Column(name="created_by",length=50)
private String createdBy;

@Column(name="created_date")
private LocalDateTime createdDate;

@Column(name="updated_date")
private LocalDateTime updatedDate;

public AccountLimit() {
	super();
}

public Long getLimitId() {
	return limitId;
}

public void setLimitId(Long limitId) {
	this.limitId = limitId;
}

public Long getAccountId() {
	return accountId;
}

public void setAccountId(Long accountId) {
	this.accountId = accountId;
}

public BigDecimal getDailyAtmLimit() {
	return dailyAtmLimit;
}

public void setDailyAtmLimit(BigDecimal dailyAtmLimit) {
	this.dailyAtmLimit = dailyAtmLimit;
}

public BigDecimal getDailyUpiLimit() {
	return dailyUpiLimit;
}

public void setDailyUpiLimit(BigDecimal dailyUpiLimit) {
	this.dailyUpiLimit = dailyUpiLimit;
}

public BigDecimal getDailyNeftLimit() {
	return dailyNeftLimit;
}

public void setDailyNeftLimit(BigDecimal dailyNeftLimit) {
	this.dailyNeftLimit = dailyNeftLimit;
}

public BigDecimal getRtgsLimit() {
	return dailyRtgsLimit;
}

public void setRtgsLimit(BigDecimal rtgsLimit) {
	this.dailyRtgsLimit = rtgsLimit;
}

public BigDecimal getDailyImpsLimit() {
	return dailyImpsLimit;
}

public void setDailyImpsLimit(BigDecimal dailyImpsLimit) {
	this.dailyImpsLimit = dailyImpsLimit;
}

public BigDecimal getMonthlyTransferLimit() {
	return monthlyTransferLimit;
}

public void setMonthlyTransferLimit(BigDecimal monthlyTransferLimit) {
	this.monthlyTransferLimit = monthlyTransferLimit;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
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
