package com.zenbank.deposit_service.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "deposit_receipt")
public class DepositReceipt {


//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "receipt_id")
//    private Long receiptId;
	
	
	@Id
	@SequenceGenerator(
	    name = "receipt_seq",
	    sequenceName = "receipt_seq",
	    initialValue = 1000,
	    allocationSize = 1
	)
	@GeneratedValue(
	    strategy = GenerationType.SEQUENCE,
	    generator = "receipt_seq"
	)
	@Column(name = "receipt_id", unique = true, nullable = false, updatable = false)
	private Long receiptId;

    @OneToOne
    @JoinColumn(name = "deposit_id", referencedColumnName = "deposit_id", nullable = false)
    private DepositTransaction depositTransaction;

    @Column(name = "receipt_number", length = 30, unique = true, nullable = false)
    private String receiptNumber;

    @Column(name = "receipt_date")
    private LocalDateTime receiptDate;

    @Column(name = "receipt_type", length = 30)
    private String receiptType;

    @Column(name = "generated_by", length = 50)
    private String generatedBy;

    @Column(name = "receipt_status", length = 20)
    private String receiptStatus;

    @Column(name = "pdf_path", length = 300)
    private String pdfPath;

    @Column(name = "remarks", length = 500)
    private String remarks;

    @Column(name = "created_by", length = 50)
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_by", length = 50)
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

	public Long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
	}

	public DepositTransaction getDepositTransaction() {
		return depositTransaction;
	}

	public void setDepositTransaction(DepositTransaction depositTransaction) {
		this.depositTransaction = depositTransaction;
	}

	public String getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

	public LocalDateTime getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(LocalDateTime receiptDate) {
		this.receiptDate = receiptDate;
	}

	public String getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(String receiptType) {
		this.receiptType = receiptType;
	}

	public String getGeneratedBy() {
		return generatedBy;
	}

	public void setGeneratedBy(String generatedBy) {
		this.generatedBy = generatedBy;
	}

	public String getReceiptStatus() {
		return receiptStatus;
	}

	public void setReceiptStatus(String receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
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