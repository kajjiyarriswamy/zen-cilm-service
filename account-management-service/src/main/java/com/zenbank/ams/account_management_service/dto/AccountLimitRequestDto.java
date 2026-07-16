package com.zenbank.ams.account_management_service.dto;

import java.math.BigDecimal;

public class AccountLimitRequestDto {
	
	
	private BigDecimal dailyAtmLimit;
	
	private BigDecimal dailyUpiLimit;
	
	private BigDecimal dailyImpsLimit;
	
	private BigDecimal dailyNeftLimit;
	
	private BigDecimal dailyRtgsLimit;
	
	private BigDecimal monthlyTransferLimit;
	
	private String status;
	
	private String createdBy;

	public AccountLimitRequestDto() {
		super();
	}

	public AccountLimitRequestDto(BigDecimal dailyAtmLimit, BigDecimal dailyUpiLimit,
			BigDecimal dailyImpsLimit, BigDecimal dailyNeftLimit, BigDecimal dailyRtgsLimit,
			BigDecimal monthlyTransferLimit, String status, String createdBy) {
		super();
		this.dailyAtmLimit = dailyAtmLimit;
		this.dailyUpiLimit = dailyUpiLimit;
		this.dailyImpsLimit = dailyImpsLimit;
		this.dailyNeftLimit = dailyNeftLimit;
		this.dailyRtgsLimit = dailyRtgsLimit;
		this.monthlyTransferLimit = monthlyTransferLimit;
		this.status = status;
		this.createdBy = createdBy;
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

	public BigDecimal getDailyImpsLimit() {
		return dailyImpsLimit;
	}

	public void setDailyImpsLimit(BigDecimal dailyImpsLimit) {
		this.dailyImpsLimit = dailyImpsLimit;
	}

	public BigDecimal getDailyNeftLimit() {
		return dailyNeftLimit;
	}

	public void setDailyNeftLimit(BigDecimal dailyNeftLimit) {
		this.dailyNeftLimit = dailyNeftLimit;
	}

	public BigDecimal getDailyRtgsLimit() {
		return dailyRtgsLimit;
	}

	public void setDailyRtgsLimit(BigDecimal dailyRtgsLimit) {
		this.dailyRtgsLimit = dailyRtgsLimit;
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

}
