package com.zenbank.cilm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,name = "Cif Number")
    private String cif_number;

    @Column(nullable = false,name = "First Name")
    private String firstName;

    @Column(nullable = false, name = "Middle Name")
    private String middleName;

    @Column(nullable = false, name = "Last Name")
    private String lastName;

    @Column(nullable = false, name = "Date Of Birth")
    private String dateOfBirth;

    @Column(nullable = false, name = "Gender")
    private String gender;

    @Column(nullable = false, name = "Marital Status")
    private String maritalStatus;

    @Column(nullable = false, name = "Occupation")
    private String occupation;

    @Column(nullable = false, name = "Annal Income")
    private String annalIncome;

    @Column(nullable = false, name = "Customer Type")
    private String customerType;

    @Column(nullable = false, name = "Customer Category")
    private String customerCategory;

    @Column(nullable = false, name = "Pan Number",unique = true)
    private String panNumber;

    @Column(nullable = false, name = "Aadhaar Number", unique = true)
    private String aadhaarNumber;

    @Column(nullable = false, name = "Nationality")
    private String nationality;

    @Column(nullable = false, name = "Customer Status")
    private String customerStatus;


    @Column(nullable = false, name = "Risk Category")
    private String riskCategory;

    @Column(nullable = false, name = "Created Date")
    private LocalDate createdDate;

    @Column(nullable = false, name = "Updated Date")
    private String updatedDate;


    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false, name = "Age")
    @Min(value = 18, message = "Age must be greater than 18")
    private String age;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, String phoneNumber, String accountNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accountNumber = accountNumber;
    }

    public Customer(Long id, String cif_number, String firstName, String middleName,
                    String lastName, String dateOfBirth, String gender,
                    String maritalStatus, String occupation, String annalIncome,
                    String customerType, String customerCategory, String panNumber,
                    String aadhaarNumber, String nationality, String customerStatus,
                    String riskCategory, LocalDate createdDate, String updatedDate,
                    String email, String phoneNumber, String accountNumber) {


        this.id = id;
        this.cif_number = cif_number;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.occupation = occupation;
        this.annalIncome = annalIncome;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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

    public String getAnnalIncome() {
        return annalIncome;
    }

    public void setAnnalIncome(String annalIncome) {
        this.annalIncome = annalIncome;
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

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
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

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
