package com.zenbank.deposit_service.dto;

import java.time.LocalDateTime;

public class UpdateDepositResponse {
	
	private String status;
	private String message; 
	private UpdateDepositResponseData data;
	
	public UpdateDepositResponse() {
	}

	public UpdateDepositResponse(String status, String message, UpdateDepositResponseData data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UpdateDepositResponseData getData() {
		return data;
	}

	public void setData(UpdateDepositResponseData data) {
		this.data = data;
	}
	
	public static class UpdateDepositResponseData{
		private Long depositId;
		private String transactionReference;
		private String approvalStatus;
		private String approvedBy;
		private String remarks;
		private String transactionStatus;
		private LocalDateTime updatedDate;
		
		public UpdateDepositResponseData() {
		}

		public UpdateDepositResponseData(Long depositId, String transactionReference, String approvalStatus,
				String approvedBy, String remarks, String transactionStatus, LocalDateTime updatedDate) {
			super();
			this.depositId = depositId;
			this.transactionReference = transactionReference;
			this.approvalStatus = approvalStatus;
			this.approvedBy = approvedBy;
			this.remarks = remarks;
			this.transactionStatus = transactionStatus;
			this.updatedDate = updatedDate;
		}

		public Long getDepositId() {
			return depositId;
		}

		public void setDepositId(Long depositId) {
			this.depositId = depositId;
		}

		public String getTransactionReference() {
			return transactionReference;
		}

		public void setTransactionReference(String transactionReference) {
			this.transactionReference = transactionReference;
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

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		public String getTransactionStatus() {
			return transactionStatus;
		}

		public void setTransactionStatus(String transactionStatus) {
			this.transactionStatus = transactionStatus;
		}

		public LocalDateTime getUpdatedDate() {
			return updatedDate;
		}

		public void setUpdatedDate(LocalDateTime updatedDate) {
			this.updatedDate = updatedDate;
		}
		
		
		
	}
	

}
