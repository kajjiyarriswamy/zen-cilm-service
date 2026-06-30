package com.zenbank.cilm.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers_kyc")
public class Customer_kyc {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kyc_id;
	
	@Column(nullable = false)
    private Long customer_id;
	
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
}
