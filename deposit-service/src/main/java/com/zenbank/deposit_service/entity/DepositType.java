package com.zenbank.deposit_service.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zenbank.deposit_service.enums.DepositStatus;
import com.zenbank.deposit_service.enums.DepositTypeCode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="deposit_type")
public class DepositType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="type_id",length =19)
	private Long typeId;
	
	@Column(name="type_code",length =20,unique = true)
	@Enumerated(EnumType.STRING)
	private DepositTypeCode typeCode;
	
	@Column(name="type_name",length =50)
	private String typeName;
	
	@Column(name="description",length =250)
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status",length =20)
	private DepositStatus status;
	
	@Column(name="created_by",length =50)
	private String createdBy;
	
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@Column(name="updated_by",length =50)
	private String updatedBy;
	
	@Column(name="updated_date")
	private LocalDateTime updatedDate;
	
	@OneToMany(mappedBy = "deposit_type",
			   cascade = CascadeType.ALL,
			   fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<DepositTransaction> depositTransaction;
	
	public DepositType() {
	}

	public DepositType(Long typeId, DepositTypeCode typeCode, String typeName, String description, DepositStatus status,
			String createdBy, LocalDateTime createdDate, String updatedBy, LocalDateTime updatedDate) {
		super();
		this.typeId = typeId;
		this.typeCode = typeCode;
		this.typeName = typeName;
		this.description = description;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public DepositTypeCode getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(DepositTypeCode typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DepositStatus getStatus() {
		return status;
	}

	public void setStatus(DepositStatus status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
	
	

}
