package com.zenbank.deposit_service.entity;

import java.security.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "deposite_channel")
public class DepositChannel {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "channel_id",length=19)
	private Long channelID ;
	
	
	@Column(name="channel_code",length=20,unique=true,nullable=false)
	private String channelCode;
	
	@Column(name="channel_name",length=50)
	private String channelName;
	
	@Column(name="description",length=250)
	private String description;
	
	@Column(name="status",length=20)
	private String status;
	
	@Column(name="created_by",length=50)
	private String createdBy;
	
	@CreationTimestamp
	@Column(name="created_date")
	private Timestamp createdDate;
	
	@Column(name="updated_by",length=50)
	private String updatedBy;
	
	@UpdateTimestamp
	@Column(name="updated_date")
	private Timestamp updatedDate;
	
	
	
	
	 
	 
	
	
	public DepositChannel() {
	}
	
	

	public DepositChannel(Long channelID, String channelCode, String channelName, String description, String status,
			String createdBy, Timestamp createdDate, String updatedBy, Timestamp updatedDate) {
		super();
		this.channelID = channelID;
		this.channelCode = channelCode;
		this.channelName = channelName;
		this.description = description;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}


	
	
	

	public Long getChannelID() {
		return channelID;
	}

	public void setChannelID(Long channelID) {
		this.channelID = channelID;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	

	 @OneToMany(mappedBy = "depositChannel") 
	private List<DepositTransaction> depositTransactions;
	

}