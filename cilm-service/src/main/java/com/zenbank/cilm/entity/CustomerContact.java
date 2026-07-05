
package com.zenbank.cilm.entity;

import com.zenbank.cilm.Enum.PreferredContactMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;




@Entity
@Table(name = "customer_contact")
public class CustomerContact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id")
	private Long contactId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@Column(name = "mobile_number", nullable = false, length = 15)
	private String mobileNumber;

	@Column(name = "alternate_mobile", length = 15)
	private String alternateMobile;

	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "landline", length = 20)
	private String landline;

	@Enumerated(EnumType.STRING)
	@Column(name = "preferred_contact_mode", length = 20)
	private PreferredContactMode preferredContactMode;

	// Default Constructor
	public CustomerContact() {
		super();
	}

	public CustomerContact(Long contactId, Customer customer, String mobileNumber, String alternateMobile, String email,
			String landline, PreferredContactMode preferredContactMode) {
		super();
		this.contactId = contactId;
		this.customer = customer;
		this.mobileNumber = mobileNumber;
		this.alternateMobile = alternateMobile;
		this.email = email;
		this.landline = landline;
		this.preferredContactMode = preferredContactMode;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAlternateMobile() {
		return alternateMobile;
	}

	public void setAlternateMobile(String alternateMobile) {
		this.alternateMobile = alternateMobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public PreferredContactMode getPreferredContactMode() {
		return preferredContactMode;
	}

	public void setPreferredContactMode(PreferredContactMode preferredContactMode) {
		this.preferredContactMode = preferredContactMode;
	}
	
	

	
}
