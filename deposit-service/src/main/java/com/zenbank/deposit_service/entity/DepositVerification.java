package com.zenbank.deposit_service.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="deposit_verification")
public class DepositVerification {
	@Id
	@Column (name="verification_id",length = 19)
	private Long verificationId;
	
	@Column (name = "deposit_id",length=19)
	private Long depositId;
	
	@Column (name = "verification_type",length = 30)
	private String verificationType;
	
	@Column (name = "verified_by",length = 50 )
    private String verifiedBy;
	
	@Column (name = "verified_date")
	private LocalDate verifiedDate;
	
	@Column (name = "approval_status",length = 20)
	private String approvalStatus;
	
	@Column (name = "rejection_reason",length = 500)
	private String rejectionReason;
	
	@Column (name = "remarks",length = 500)
	private String remarks;
	 
	@Column (name = "created_by",length = 60)
	 private String createdBy;
	
	@Column (name = "created_date")
	private LocalDate createdDate;
	
	@Column (name = "updated_by",length = 50)
	private String updatedBy;
	
	@Column (name = "updated_date")
	private LocalDate updatedDate;

	public DepositVerification() {
		super();
	}

	public DepositVerification(Long verificationId, Long depositId, String verificationType, String verifiedBy,
			LocalDate verifiedDate, String approvalStatus, String rejectionReason, String remarks, String createdBy,
			LocalDate createdDate, String updatedBy, LocalDate updatedDate) {
		super();
		this.verificationId = verificationId;
		this.depositId = depositId;
		this.verificationType = verificationType;
		this.verifiedBy = verifiedBy;
		this.verifiedDate = verifiedDate;
		this.approvalStatus = approvalStatus;
		this.rejectionReason = rejectionReason;
		this.remarks = remarks;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public Long getVerificationId() {
		return verificationId;
	}

	public void setVerificationId(Long verificationId) {
		this.verificationId = verificationId;
	}

	public Long getDepositId() {
		return depositId;
	}

	public void setDepositId(Long depositId) {
		this.depositId = depositId;
	}

	public String getVerificationType() {
		return verificationType;
	}

	public void setVerificationType(String verificationType) {
		this.verificationType = verificationType;
	}

	public String getVerifiedBy() {
		return verifiedBy;
	}

	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}

	public LocalDate getVerifiedDate() {
		return verifiedDate;
	}

	public void setVerifiedDate(LocalDate verifiedDate) {
		this.verifiedDate = verifiedDate;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	

}
