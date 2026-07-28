package com.zenbank.ams.account_management_service.dto;

public class CancelAccountClosureRequestDto {
	private String cancelReason;
	private String cancelledBy;
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancellationReason) {
		this.cancelReason = cancellationReason;
	}
	public String getCancelledBy() {
		return cancelledBy;
	}
	public void setCancelledBy(String cancelledBy) {
		this.cancelledBy = cancelledBy;
	}
	public CancelAccountClosureRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
