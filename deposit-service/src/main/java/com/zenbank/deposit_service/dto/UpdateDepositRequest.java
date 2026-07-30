package com.zenbank.deposit_service.dto;

public class UpdateDepositRequest {
	
	private String remarks;
	private String approvalStatus;
	private String approvedBy;
	private String branchCode;
	private String branchName;
	
	public UpdateDepositRequest() {
	}

	public UpdateDepositRequest(String remarks, String approvalStatus, String approvedBy, String branchCode,
			String branchName) {
		super();
		this.remarks = remarks;
		this.approvalStatus = approvalStatus;
		this.approvedBy = approvedBy;
		this.branchCode = branchCode;
		this.branchName = branchName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	

}
