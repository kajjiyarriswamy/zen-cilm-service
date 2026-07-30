package com.zenbank.ams.account_management_service.dto;

public class CloseAccountRequestDto {
	private String closureReason;
    private String remarks;
	public CloseAccountRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getClosureReason() {
		return closureReason;
	}
	public void setClosureReason(String closureReason) {
		this.closureReason = closureReason;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
    
}
