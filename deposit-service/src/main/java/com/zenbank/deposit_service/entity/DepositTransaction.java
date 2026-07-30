package com.zenbank.deposit_service.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "deposit_transaction")
public class DepositTransaction {
	
	  @Id
	  @SequenceGenerator(name = "bank", sequenceName = "depositid", initialValue =
	  1000, allocationSize = 1)
	  @GeneratedValue(generator = "bank", strategy = GenerationType.SEQUENCE)	
	  
	  @Column(name = "deposit_id", unique = true, nullable = false, updatable =
	  false, length = 20) private Long depositId;


	@Column(name = "transaction_reference", unique = true, nullable = false, updatable = false, length = 20)
	private String transactionReference;

	@Column(name = "account_id", nullable = false, updatable = false)
	private Long accountId;

	@Column(name = "customer_id", nullable = false, updatable = false)
	private Long customerId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="deposit_type_id",referencedColumnName ="type_id")
	private DepositType depositType;
		
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="deposit_channel_id",referencedColumnName ="channel_id")
	private DepositChannel depositChannel;
		
	@Column(name="amount", nullable = false,updatable = false)
	private BigDecimal amount;

	@Column(name = "currency", nullable = false, updatable = false)
	private String currency;
	
	@Column(name="transaction_date", nullable = false,updatable = false)
	private LocalDateTime transactionDate;
	
	@Column(name="value_date", nullable = false,updatable = false)
	private LocalDate valueDate;
	@Column(name = "transaction_status", nullable = false)
	private String transactionStatus;
	@Column(name = "remarks", nullable = false)
	private String remarks;
	@Column(name = "branch_code", nullable = false, updatable = false)
	private String branchCode;
	@Column(name = "branch_name", nullable = false, updatable = false)
	private String branchName;
	@Column(name = "initiated_by", nullable = false, updatable = false)
	private String initiatedBy;
	@Column(name = "approved_by", nullable = false, updatable = false)
	private String approvedBy;
	@Column(name = "approval_status", nullable = false)
	private String approvalStatus;
	@Column(name = "created_by", nullable = false)
	private String createdBy;
	@Column(name = "created_date", nullable = false, updatable = false)
	private LocalDate createdDate;
	@Column(name = "updated_by", nullable = false)
	private String updatedBy;
	@Column(name = "updated_date", nullable = false)
	private LocalDate updatedDate;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="deposit_receipt_id",referencedColumnName ="receipt_id")
	private DepositReceipt depositReceipt;
	
	public DepositTransaction() {
		super();
	}

	public DepositTransaction(Long depositId, String transactionReference, Long accountId, Long customerId,
			DepositType depositType,DepositChannel depositChannel,BigDecimal amount, String currency,
			LocalDateTime transactionDate, LocalDate valueDate, String transactionStatus, String remarks, String branchCode,
			String branchName, String initiatedBy, String approvedBy, String approvalStatus, String createdBy,
			LocalDate createdDate, String updatedBy, LocalDate updatedDate, List<DepositStatusHistory> statusHistory,DepositReceipt depositReceipt) {
		super();
		this.depositId = depositId;
		this.transactionReference = transactionReference;
		this.accountId = accountId;
		this.customerId = customerId;
		this.depositType = depositType;
		this.depositChannel = depositChannel;
		this.amount = amount;
		this.currency = currency;
		this.transactionDate = transactionDate;
		this.valueDate = valueDate;
		this.transactionStatus = transactionStatus;
		this.remarks = remarks;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.initiatedBy = initiatedBy;
		this.approvedBy = approvedBy;
		this.approvalStatus = approvalStatus;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.statusHistory = statusHistory;
		this.depositReceipt = depositReceipt;
	}

	public Long getDepositId() {
		return depositId;
	}

	public void setDepositId(Long depositId) {
		this.depositId = depositId;
	}

	public String getTransactionReference() {
		return transactionReference;
	}

	public void setTransactionReference(String transactionReference) {
		this.transactionReference = transactionReference;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public DepositType getDepositType() {
		return depositType;
	}

	public void setDepositType(DepositType depositType) {
		this.depositType = depositType;
	}

	public DepositChannel getDepositChannel() {
		return depositChannel;
	}

	public void setDepositChannel(DepositChannel depositChannel) {
		this.depositChannel = depositChannel;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public LocalDate getValueDate() {
		return valueDate;
	}

	public void setValueDate(LocalDate valueDate) {
		this.valueDate = valueDate;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getInitiatedBy() {
		return initiatedBy;
	}


	public void setInitiatedBy(String initiatedBy) {
		this.initiatedBy = initiatedBy;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
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

	public List<DepositStatusHistory> getStatusHistory() {
		return statusHistory;
	}

	public void setStatusHistory(List<DepositStatusHistory> statusHistory) {
		this.statusHistory = statusHistory;
	}
	
	public DepositReceipt getDepositReceipt() {
		return depositReceipt;
	}

	public void setDepositReceipt(DepositReceipt depositReceipt) {
		this.depositReceipt = depositReceipt;
	}

	@OneToMany(mappedBy = "depositTransaction", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DepositStatusHistory> statusHistory;

	
//	  // @ManyToOne(fetch=FetchType.LAZY)
//	  // @JoinColumn(name="deposit_type_id",referencedColumnName ="type_id") //
//	  private DepositType depositType;
//	 //
//	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="deposit_channel_id",referencedColumnName ="channel_id")
//	private DepositChannel depositchannel;


}
