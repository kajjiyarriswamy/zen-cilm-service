package com.zenbank.ams.account_management_service.dto;

import java.math.BigDecimal;

import com.zenbank.ams.account_management_service.entity.AccountLimit;

public class GetAccountLimitResponseDto {
	
	private Long accountId;
	
	private BigDecimal dailyAtmLimit;
	
	private BigDecimal dailyUpiLimit;
	
	private BigDecimal dailyImpsLimit;
	
	private BigDecimal dailyNeftLimit;
	
	private BigDecimal dailyRtgsLimit;

	public GetAccountLimitResponseDto() {
		super();
	}

	public GetAccountLimitResponseDto(Long accountId,BigDecimal dailyAtmLimit, BigDecimal dailyUpiLimit, BigDecimal dailyImpsLimit,
			BigDecimal dailyNeftLimit, BigDecimal dailyRtgsLimit) {
		super();
		
		this.accountId = accountId;
		this.dailyAtmLimit = dailyAtmLimit;
		this.dailyUpiLimit = dailyUpiLimit;
		this.dailyImpsLimit = dailyImpsLimit;
		this.dailyNeftLimit = dailyNeftLimit;
		this.dailyRtgsLimit = dailyRtgsLimit;
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

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	public static GetAccountLimitResponseDto fromEntity(AccountLimit accountLimit) {
        return new GetAccountLimitResponseDto(
                accountLimit.getAccount().getAccountId(),
                accountLimit.getDailyAtmLimit(),
                accountLimit.getDailyUpiLimit(),
                accountLimit.getDailyImpsLimit(),
                accountLimit.getDailyNeftLimit(),
                accountLimit.getRtgsLimit()
        );
    }
}
