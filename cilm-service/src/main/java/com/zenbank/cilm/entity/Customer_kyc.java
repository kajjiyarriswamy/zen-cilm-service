package com.zenbank.cilm.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers_kyc")
public class Customer_kyc {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kyc_id;
	
	@OneToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;
	
	@Column(nullable = false)
    private Boolean pan_verified;
	
	@Column(nullable = false)
    private Boolean aadhaar_verified;
	
	@Column(nullable = false)
	private String kyc_status;
	
	@Column(nullable=false)
	private String verified_by;
	
	@Column(nullable=false)
	private Date verified_date;

	public Long getKyc_id() {
		return kyc_id;
	}

	public void setKyc_id(Long kyc_id) {
		this.kyc_id = kyc_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Boolean getPan_verified() {
		return pan_verified;
	}

	public void setPan_verified(Boolean pan_verified) {
		this.pan_verified = pan_verified;
	}

	public Boolean getAadhaar_verified() {
		return aadhaar_verified;
	}

	public void setAadhaar_verified(Boolean aadhaar_verified) {
		this.aadhaar_verified = aadhaar_verified;
	}

	public String getKyc_status() {
		return kyc_status;
	}

	public void setKyc_status(String kyc_status) {
		this.kyc_status = kyc_status;
	}

	public String getVerified_by() {
		return verified_by;
	}

	public void setVerified_by(String verified_by) {
		this.verified_by = verified_by;
	}

	public Date getVerified_date() {
		return verified_date;
	}

	public void setVerified_date(Date verified_date) {
		this.verified_date = verified_date;
	}

	public Customer_kyc(Long kyc_id, Customer customer, Boolean pan_verified, Boolean aadhaar_verified,
			String kyc_status, String verified_by, Date verified_date) {
		super();
		this.kyc_id = kyc_id;
		this.customer = customer;
		this.pan_verified = pan_verified;
		this.aadhaar_verified = aadhaar_verified;
		this.kyc_status = kyc_status;
		this.verified_by = verified_by;
		this.verified_date = verified_date;
	}

	public Customer_kyc() {
		super();
	}
		
}
