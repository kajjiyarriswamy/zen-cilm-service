package com.zenbank.cilm.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_kyc")
public class CustomerKyc {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kyc_id")
    private Long kycId;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
	
    @Column(name = "pan_verified", nullable = false)
    private Boolean panVerified;

    @Column(name = "aadhaar_verified", nullable = false)
    private Boolean aadhaarVerified;

    @Column(name = "kyc_status", nullable = false)
    private String kycStatus;

    @Column(name = "verified_by", nullable = false)
    private String verifiedBy;
	
    @CreationTimestamp
    @Column(name = "verified_date", nullable = false, updatable = false)
    private LocalDateTime verifiedDate;
    
    

	public Long getKycId() {
		return kycId;
	}



	public void setKycId(Long kycId) {
		this.kycId = kycId;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Boolean getPanVerified() {
		return panVerified;
	}



	public void setPanVerified(Boolean panVerified) {
		this.panVerified = panVerified;
	}



	public Boolean getAadhaarVerified() {
		return aadhaarVerified;
	}



	public void setAadhaarVerified(Boolean aadhaarVerified) {
		this.aadhaarVerified = aadhaarVerified;
	}



	public String getKycStatus() {
		return kycStatus;
	}



	public void setKycStatus(String kycStatus) {
		this.kycStatus = kycStatus;
	}



	public String getVerifiedBy() {
		return verifiedBy;
	}



	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}



	public LocalDateTime getVerifiedDate() {
		return verifiedDate;
	}



	public void setVerifiedDate(LocalDateTime verifiedDate) {
		this.verifiedDate = verifiedDate;
	}
	
	

	public CustomerKyc(Long kycId, Customer customer, Boolean panVerified, Boolean aadhaarVerified, String kycStatus,
			String verifiedBy, LocalDateTime verifiedDate) {
		super();
		this.kycId = kycId;
		this.customer = customer;
		this.panVerified = panVerified;
		this.aadhaarVerified = aadhaarVerified;
		this.kycStatus = kycStatus;
		this.verifiedBy = verifiedBy;
		this.verifiedDate = verifiedDate;
	}



	public CustomerKyc() {
		super();
	}
		
}
