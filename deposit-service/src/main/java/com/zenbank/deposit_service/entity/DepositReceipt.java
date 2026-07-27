package com.zenbank.deposit_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "deposit_receipt")
public class DepositReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_id")
    private Long receiptId;

    @Column(name = "receipt_number", unique = true, nullable = false, length = 50)
    private String receiptNumber;

    @Column(name = "generated_date", nullable = false)
    private LocalDateTime generatedDate;

    @Lob
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;
    
    @OneToOne(mappedBy = "depositReceipt")
	private DepositTransaction depositTransaction;

    public DepositReceipt() {
    }

    public DepositReceipt(String receiptNumber, LocalDateTime generatedDate, String content) {
        this.receiptNumber = receiptNumber;
        this.generatedDate = generatedDate;
        this.content = content;
    }

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }


    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public LocalDateTime getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDateTime generatedDate) {
        this.generatedDate = generatedDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	public DepositTransaction getDepositTransaction() {
		return depositTransaction;
	}

	public void setDepositTransaction(DepositTransaction depositTransaction) {
		this.depositTransaction = depositTransaction;
	}
    
}
