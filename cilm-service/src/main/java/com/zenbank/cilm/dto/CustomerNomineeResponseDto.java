package com.zenbank.cilm.dto;

import java.time.LocalDate;

public class CustomerNomineeResponseDto {

    private String nomineeId;
    private String verificationStatus;
    private String nomineeName;
    private String relationship;
    private String mobile;
    private LocalDate dob;
    private Integer sharePercentage;


    public CustomerNomineeResponseDto() {
    }

    public CustomerNomineeResponseDto(String nomineeId, String verificationStatus) {
        this.nomineeId = nomineeId;
        this.verificationStatus = verificationStatus;
    }

    public String getNomineeId() {
        return nomineeId;
    }

    public void setNomineeId(String nomineeId) {
        this.nomineeId = nomineeId;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Integer getSharePercentage() {
		return sharePercentage;
	}

	public void setSharePercentage(Integer sharePercentage) {
		this.sharePercentage = sharePercentage;
	}
    

}
