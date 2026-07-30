package com.zenbank.ams.account_management_service.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateJointHolderRequest {
	
	@NotBlank(message="customer id is Rrequierd")
	private String customerId;
	
	@NotBlank(message="Holder Name is Required")
	private String holderName;
	
	@NotBlank(message= "Relationship is required")
	private String relationship;
	
	@NotBlank(message = "operation Mode is required")
	private String operationMode;

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

	
}
