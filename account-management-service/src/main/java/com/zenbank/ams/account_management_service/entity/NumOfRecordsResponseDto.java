package com.zenbank.ams.account_management_service.entity;

import java.util.List;

public class NumOfRecordsResponseDto {
	
	private String status;
	
	private int count;
	
	private List accounts;

	public NumOfRecordsResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NumOfRecordsResponseDto(String status, int count, List accounts) {
		super();
		this.status = status;
		this.count = count;
		this.accounts = accounts;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List getAccounts() {
		return accounts;
	}

	public void setAccounts(List accounts) {
		this.accounts = accounts;
	}

	
	

}
