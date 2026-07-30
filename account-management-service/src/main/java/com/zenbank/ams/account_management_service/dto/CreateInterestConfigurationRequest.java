package com.zenbank.ams.account_management_service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateInterestConfigurationRequest {
	private String accountType;
    private BigDecimal interestRate;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public BigDecimal getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}
	public LocalDate getEffectiveFrom() {
		return effectiveFrom;
	}
	public void setEffectiveFrom(LocalDate effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}
	public LocalDate getEffectiveTo() {
		return effectiveTo;
	}
	public void setEffectiveTo(LocalDate effectiveTo) {
		this.effectiveTo = effectiveTo;
	}
    
    

}
