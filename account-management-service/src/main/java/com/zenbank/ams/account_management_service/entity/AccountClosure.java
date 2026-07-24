package com.zenbank.ams.account_management_service.entity;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "account_closure")
public class AccountClosure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "closure_seq")
    @SequenceGenerator(name = "closure_seq",sequenceName = "closure_seq",allocationSize = 1)
    @Column(name = "closure_id")
    private Long closureId;
	
	@OneToOne
	@JoinColumn(name = "account_id", referencedColumnName = "account_id")
	private Account account;
	
	@Column(name="closure_reason",nullable=false,length=100)
	private String closureReason;
	
	@Column(name="closure_status",nullable=false,length=20)
	private String closureStatus;
	
	@Column(name="cancelled_by",length=50)
	private String cancelledBy;
	
	@Column(name="closed_by",nullable=false,length=50)
	private String closedBy;
	
	@Column(name="closed_date",nullable=false)
	private LocalDateTime closedDate;
	
	@Column(name="cancelled_date")
	private LocalDateTime cancelledDate;
	
	@Column(name="remarks",length=255)
	private String remarks;
	
	@Column(name="cancellation_reason",length=100)
	private String cancelReason;

	

	public Long getClosureId() {
		return closureId;
	}



	public void setClosureId(Long closureId) {
		this.closureId = closureId;
	}



	public Account getAccount() {
		return account;
	}



	public void setAccount(Account account) {
		this.account = account;
	}



	public String getClosureReason() {
		return closureReason;
	}



	public void setClosureReason(String closureReason) {
		this.closureReason = closureReason;
	}



	public String getClosureStatus() {
		return closureStatus;
	}



	public void setClosureStatus(String closureStatus) {
		this.closureStatus = closureStatus;
	}



	public String getCancelledBy() {
		return cancelledBy;
	}



	public void setCancelledBy(String cancelledBy) {
		this.cancelledBy = cancelledBy;
	}



	public String getClosedBy() {
		return closedBy;
	}



	public void setClosedBy(String closedBy) {
		this.closedBy = closedBy;
	}



	public LocalDateTime getClosedDate() {
		return closedDate;
	}



	public void setClosedDate(LocalDateTime closedDate) {
		this.closedDate = closedDate;
	}



	public LocalDateTime getCancelledDate() {
		return cancelledDate;
	}



	public void setCancelledDate(LocalDateTime cancelledDate) {
		this.cancelledDate = cancelledDate;
	}



	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public String getCancelReason() {
		return cancelReason;
	}



	public void setCancelReason(String cancellationReason) {
		this.cancelReason = cancellationReason;
	}
	
	


	public AccountClosure(Long closureId, Account account, String closureReason, String closureStatus,
			String cancelledBy, String closedBy, LocalDateTime closedDate, LocalDateTime cancelledDate, String remarks,
			String cancellationReason) {
		super();
		this.closureId = closureId;
		this.account = account;
		this.closureReason = closureReason;
		this.closureStatus = closureStatus;
		this.cancelledBy = cancelledBy;
		this.closedBy = closedBy;
		this.closedDate = closedDate;
		this.cancelledDate = cancelledDate;
		this.remarks = remarks;
		this.cancelReason = cancellationReason;
	}



	public AccountClosure() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
