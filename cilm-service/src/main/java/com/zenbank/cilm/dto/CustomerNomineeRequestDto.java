package com.zenbank.cilm.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class CustomerNomineeRequestDto {
    @NotBlank(message = "Nominee name is mandatory")
    private String nomineeName;

    @NotBlank(message = "Relationship is mandatory")
    private String relationship;

    @NotNull(message = "Date of Birth is mandatory")
    @Past(message = "Date of Birth cannot be a future date")
    private LocalDate dob;

    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must contain 10 digits")
    private String mobile;

    @NotNull(message = "Share percentage is mandatory")
    @Positive(message = "Share percentage must be greater than 0")
    private Double sharePercentage;
    
    private String verificationStatus;

    public CustomerNomineeRequestDto() {
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

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}
    
}
