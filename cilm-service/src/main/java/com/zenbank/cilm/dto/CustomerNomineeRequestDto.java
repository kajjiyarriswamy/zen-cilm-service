package com.zenbank.cilm.dto;

import java.time.LocalDate;

public class CustomerNomineeRequestDto {
	private String nomineeName;
    private String relationship;
    private LocalDate dob;
    private String mobile;
    private Double sharePercentage;

    public CustomerNomineeRequestDto() {
    }

    public CustomerNomineeRequestDto(String nomineeName, String relationship,
                                     LocalDate dob, String mobile,
                                     Double sharePercentage) {
        this.nomineeName = nomineeName;
        this.relationship = relationship;
        this.dob = dob;
        this.mobile = mobile;
        this.sharePercentage = sharePercentage;
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

}
