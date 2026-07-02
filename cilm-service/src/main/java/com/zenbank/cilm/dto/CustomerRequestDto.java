package com.zenbank.cilm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CustomerRequestDto {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String middleName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Marital Status is required")
    private String maritalStatus;

    @NotBlank(message = "Occupation is required")
    private String occupation;

    @NotBlank(message = "Annual Income is required")
    private String annualIncome;

    @NotBlank(message = "Customer Type is required")
    private String customerType;

    @NotBlank(message = "Customer Category is required")
    private String customerCategory;

    @NotBlank(message = "Aadhaar Number is required")
    private String aadhaarNumber;

    @NotBlank(message = "Pan Number is required")
    private String panNumber;

    @NotNull(message = "Age is required")
    private Integer age;

    @NotBlank(message = "Nationality is required")
    private String nationality;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    private String customerStatus;



    public  String getMiddleName() {
        return middleName;
    }

    public void setMiddleName( String middleName) {
        this.middleName = middleName;
    }

    public  String getGender() {
        return gender;
    }

    public void setGender( String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth( LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public  String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus( String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public  String getOccupation() {
        return occupation;
    }

    public void setOccupation( String occupation) {
        this.occupation = occupation;
    }

    public  String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome( String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public  String getCustomerType() {
        return customerType;
    }

    public void setCustomerType( String customerType) {
        this.customerType = customerType;
    }

    public  String getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory( String customerCategory) {
        this.customerCategory = customerCategory;
    }

    public  String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber( String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber( String panNumber) {
        this.panNumber = panNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality( String nationality) {
        this.nationality = nationality;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }
}
