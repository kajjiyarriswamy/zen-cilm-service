package com.zenbank.deposit_service.entity;

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
@Table(name = "deposit_status_history")
public class DepositStatusHistory {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "status_history_id")
	    private Long statusHistoryId;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "deposit_id", nullable = false)
	    private DepositTransaction depositTransaction;

	    @Column(name = "previous_status", length = 30)
	    private String previousStatus;

	    @Column(name = "current_status", length = 30)
	    private String currentStatus;

	    @Column(name = "changed_by", length = 50)
	    private String changedBy;

	    @Column(name = "changed_date")
	    private LocalDateTime changedDate;

	    @Column(name = "reason", length = 300)
	    private String reason;

	    @Column(name = "remarks", length = 500)
	    private String remarks;

	    @Column(name = "created_by", length = 50)
	    private String createdBy;

	    @Column(name = "created_date")
	    private LocalDateTime createdDate;

	    public DepositStatusHistory() {
	    }

		public DepositStatusHistory(Long statusHistoryId, DepositTransaction depositTransaction, String previousStatus,
				String currentStatus, String changedBy, LocalDateTime changedDate, String reason, String remarks,
				String createdBy, LocalDateTime createdDate) {
			super();
			this.statusHistoryId = statusHistoryId;
			this.depositTransaction = depositTransaction;
			this.previousStatus = previousStatus;
			this.currentStatus = currentStatus;
			this.changedBy = changedBy;
			this.changedDate = changedDate;
			this.reason = reason;
			this.remarks = remarks;
			this.createdBy = createdBy;
			this.createdDate = createdDate;
		}

		public Long getStatusHistoryId() {
			return statusHistoryId;
		}

		public void setStatusHistoryId(Long statusHistoryId) {
			this.statusHistoryId = statusHistoryId;
		}

		public DepositTransaction getDepositTransaction() {
			return depositTransaction;
		}

		public void setDepositTransaction(DepositTransaction depositTransaction) {
			this.depositTransaction = depositTransaction;
		}

		public String getPreviousStatus() {
			return previousStatus;
		}

		public void setPreviousStatus(String previousStatus) {
			this.previousStatus = previousStatus;
		}

		public String getCurrentStatus() {
			return currentStatus;
		}

		public void setCurrentStatus(String currentStatus) {
			this.currentStatus = currentStatus;
		}

		public String getChangedBy() {
			return changedBy;
		}

		public void setChangedBy(String changedBy) {
			this.changedBy = changedBy;
		}

		public LocalDateTime getChangedDate() {
			return changedDate;
		}

		public void setChangedDate(LocalDateTime changedDate) {
			this.changedDate = changedDate;
		}

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
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
	    
	    

}
