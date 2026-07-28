package com.zenbank.cilm.dto;

public class CustomerKycRejectRequestDto {

    private String reason;
    private String verifiedBy;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getVerifiedBy() {
		return verifiedBy;
	}
	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}

    // Getters and Setters
    
}