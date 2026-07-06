package com.zenbank.cilm.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name="customer_document")
public class CustomerDocument {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long documentId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
	private Customer customer;

	@Column(name = "document_number", nullable = false, length = 110)
	private String documentNumber;

	@Column(name = "document_path", nullable = false, length = 300)
	private String documentPath;

	@Column(name = "verification_status", nullable=false, length=50)
	private String verificationStatus;

	@CreationTimestamp
	@Column(name = "uploaded_date", nullable = false, updatable = false)
	private LocalDateTime uploadedDate;

	public CustomerDocument(Long documentId, Customer customer, String documentNumber, String path, String status,
			LocalDateTime uploadedDate) {
		super();
		this.documentId = documentId;
		this.customer = customer;
		this.documentNumber = documentNumber;
		this.documentPath = path;
		this.verificationStatus = status;
		this.uploadedDate = uploadedDate;
	}

	public Long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getPath() {
		return documentPath;
	}

	public void setPath(String path) {
		this.documentPath = path;
	}

	public String getStatus() {
		return verificationStatus;
	}

	public void setStatus(String status) {
		this.verificationStatus = status;
	}

	public LocalDateTime getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(LocalDateTime uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
	
	
	

}
