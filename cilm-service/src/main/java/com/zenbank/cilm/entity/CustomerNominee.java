package com.zenbank.cilm.entity;

import java.time.LocalDate;

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
@Table(name = "customer_nominee")
public class CustomerNominee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nominee_id")
    private Long nomineeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "nominee_name", nullable = false)
    private String nomineeName;

    @Column(name = "relationship", nullable = false)
    private String relationship;

    @Column(name = "verification_status" , nullable = false)
    private String verificationStatus;

    @Column(name = "dob" , nullable = false)
    private LocalDate dob;

    @Column(name = "mobile" ,nullable = false)
    private String mobile;

    @Column(name = "share_percentage" ,nullable = false)
    private Double sharePercentage;
    
    public CustomerNominee() {
    }

	public CustomerNominee(Long nomineeId, Customer customer, String nomineeName, String relationship,
			String verificationStatus, LocalDate dob, String mobile, Double sharePercentage) {
		super();
		this.nomineeId = nomineeId;
		this.customer = customer;
		this.nomineeName = nomineeName;
		this.relationship = relationship;
		this.verificationStatus = verificationStatus;
		this.dob = dob;
		this.mobile = mobile;
		this.sharePercentage = sharePercentage;
	}

	public Long getNomineeId() {
		return nomineeId;
	}

	public void setNomineeId(Long nomineeId) {
		this.nomineeId = nomineeId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Double getSharePercentage() {
		return sharePercentage;
	}

	public void setSharePercentage(Double sharePercentage) {
		this.sharePercentage = sharePercentage;
	}
	


	

	}

