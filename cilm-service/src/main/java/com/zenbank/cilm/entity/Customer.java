
package com.zenbank.cilm.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.Min;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zenbank.cilm.Enum.CustomerStatus;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "customer_id", unique = true, nullable = false, updatable = false, length = 20)
	private String customerId;

	@Column(unique = true, name = "cif_number")
	private String cif_number;

	@Column(nullable = false, name = "first_name")
	private String firstName;

	@Column(nullable = false, name = "middle_name")
	private String middleName;

	@Column(nullable = false, name = "last_name")
	private String lastName;

	@Column(nullable = false, name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(nullable = false)
	private String gender;

	@Column(nullable = false, name = "marital_status")
	private String maritalStatus;

	@Column(nullable = false)
	private String occupation;

	@Column(nullable = false, name = "annal_income")
	private String annualIncome;

	@Column(nullable = false, name = "customer_type")
	private String customerType;

	@Column(nullable = false, name = "customer_category")
	private String customerCategory;

	@Column(nullable = false, name = "pan_number", unique = true)
	private String panNumber;

	@Column(nullable = false, name = "aadhaar_number", unique = true)
	private String aadhaarNumber;

	@Column(nullable = false)
	private String nationality;


	@Enumerated(EnumType.STRING)
	@Column(name = "customer_status")
	private CustomerStatus customerStatus;

	@Column(name = "risk_category")
	private String riskCategory;

	@Column(nullable = false, name = "created_date")
	private LocalDate createdDate;

	@Column(name = "updated_date")
	private LocalDate updatedDate;

	
	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false, unique = true)
	private String phoneNumber;

	@Column(nullable = false)
	@Min(value = 18, message = "Age must be greater than 18")
	private Integer age;

	@OneToMany(mappedBy = "customer",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<CustomerAddress> addresses;
	
	
	 @Column(nullable = false)
	    private String accountNumber;


	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)//, fetch = FetchType.LAZY)
	    @JsonManagedReference
	    private CustomerPreferences customerPreference;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<CustomerContact> contacts;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<CustomerKyc> customerKycs;
	    
	    public Customer() {
	    }



	    public Customer(String firstName, String lastName, String email, String phoneNumber, String accountNumber) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.phoneNumber = phoneNumber;
	        this.accountNumber = accountNumber;
	    }

    public String getCustomerId() {
        return customerId;

    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


    public Customer(Long id, String cif_number, String firstName, String middleName, String lastName, LocalDate dateOfBirth, String gender, String maritalStatus, String occupation, String annalIncome, String customerType, String customerCategory, String panNumber, String aadhaarNumber, String nationality, CustomerStatus customerStatus, String riskCategory, LocalDate createdDate, LocalDate updatedDate, String email, String phoneNumber, String accountNumber, Integer age) {
        this.id = id;
        this.cif_number = cif_number;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.occupation = occupation;
        this.annualIncome = annalIncome;
        this.customerType = customerType;
        this.customerCategory = customerCategory;
        this.panNumber = panNumber;
        this.aadhaarNumber = aadhaarNumber;
        this.nationality = nationality;
        this.customerStatus = customerStatus;
        this.riskCategory = riskCategory;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accountNumber = accountNumber;
        this.age = age;
    }


    



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCif_number() {
		return cif_number;
	}



	public void setCif_number(String cif_number) {
		this.cif_number = cif_number;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getMiddleName() {
		return middleName;
	}



	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public LocalDate getDateOfBirth(){
		return dateOfBirth;
	}



	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getMaritalStatus() {
		return maritalStatus;
	}



	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}



	public String getOccupation() {
		return occupation;
	}



	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}



	public String getAnnualIncome() {
		return annualIncome;
	}



	public void setAnnalIncome(String annalIncome) {
		this.annualIncome = annalIncome;
	}



	public String getCustomerType() {
		return customerType;
	}



	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}



	public String getCustomerCategory() {
		return customerCategory;
	}



	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}



	public String getPanNumber() {
		return panNumber;
	}



	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}



	public String getAadhaarNumber() {
		return aadhaarNumber;
	}



	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}



	public String getNationality() {
		return nationality;
	}



	public void setNationality(String nationality) {
		this.nationality = nationality;
	}



	public CustomerStatus getCustomerStatus() {
		return customerStatus;
	}



	public void setCustomerStatus(CustomerStatus customerStatus) {
		this.customerStatus = customerStatus;
	}



	public String getRiskCategory() {
		return riskCategory;
	}



	public void setRiskCategory(String riskCategory) {
		this.riskCategory = riskCategory;
	}



	public LocalDate getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}



	public LocalDate getUpdatedDate() {
		return updatedDate;
	}



	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public String getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public CustomerPreferences getCustomerPreference() {
		return customerPreference;
	}



	public void setCustomerPreference(CustomerPreferences customerPreference) {
		this.customerPreference = customerPreference;
	}



	public List<CustomerAddress> getAddresses() {
		return addresses;
	}



	public void setAddresses(List<CustomerAddress> addresses) {
		this.addresses = addresses;
	}



	public List<CustomerContact> getContacts() {
		return contacts;
	}



	public void setContacts(List<CustomerContact> contacts) {
		this.contacts = contacts;
	}



	public List<CustomerKyc> getCustomerKycs() {
		return customerKycs;
	}



	public void setCustomerKycs(List<CustomerKyc> customerKycs) {
		this.customerKycs = customerKycs;
	}
	

}
	
