package com.zenbank.ams.account_management_service.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "joint_account_holder")
public class JointAccountHolder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="holder_id")
	private Long holderId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="account_id", nullable = false)
	private Account account;
	
	@Column(name= "customer_id")
	private String customerId;
	
	@Column(name="holder_name", length = 100, nullable = false)
	private String holderName;
	
	@Column(name="relationship" , length = 50, nullable = false)
	private String relationship;
	
	@Column(name="operation_mode", length = 30, nullable = false)
	private String operationMode;
	
	@Column(name="status", length = 20, nullable = false)
	private String status;
	
	@Column(name="create_date")
	private LocalDateTime createDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="update_date")
	private LocalDateTime updatedDate;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	public JointAccountHolder() {
		
	}

	public JointAccountHolder(Long holderId, Account account, String customerId, String holderName, String relationship,
			String operationMode, String status, LocalDateTime createDate, String createdBy, LocalDateTime updatedDate,
			String updatedBy) {
		super();
		this.holderId = holderId;
		this.account = account;
		this.customerId = customerId;
		this.holderName = holderName;
		this.relationship = relationship;
		this.operationMode = operationMode;
		this.status = status;
		this.createDate = createDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	public Long getHolderId() {
		return holderId;
	}

	public void setHolderId(Long holderId) {
		this.holderId = holderId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getOperationMode() {
		return operationMode;
	}

	public void setOperationMode(String operationMode) {
		this.operationMode = operationMode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	

	
}
