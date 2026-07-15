package com.zenbank.ams.account_management_service.dto;

import com.zenbank.ams.account_management_service.entity.AccountLimit;

public class AccountLimitResponseDto { 
	
	private Long accountId;
	
	private Long limitId;	
		
	public AccountLimitResponseDto() {
		super();
	}

public AccountLimitResponseDto(Long accountId, Long limitId) {
	super();
	this.accountId = accountId;
	this.limitId = limitId;
}

public Long getAccountId() {
	return accountId;
}

public void setAccountId(Long accountId) {
	this.accountId = accountId;
}

public Long getLimitId() {
	return limitId;
}

public void setLimitId(Long limitId) {
	this.limitId = limitId;
}	

public static AccountLimitResponseDto fromEntity(AccountLimit accountent) {
	return new AccountLimitResponseDto(accountent.getAccountId(),accountent.getLimitId());
}
		

}
