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
	
	@Column(name="closed_by",nullable=false,length=50)
	private String closedBy;
	
	@Column(name="closed_date",nullable=false)
	private LocalDateTime closedDate;
	
	@Column(name="remarks",length=255)
	private String remarks;

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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public AccountClosure(Long closureId, Account account, String closureReason, String closureStatus, String closedBy,
			LocalDateTime closedDate, String remarks) {
		super();
		this.closureId = closureId;
		this.account = account;
		this.closureReason = closureReason;
		this.closureStatus = closureStatus;
		this.closedBy = closedBy;
		this.closedDate = closedDate;
		this.remarks = remarks;
	}

	public AccountClosure() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
