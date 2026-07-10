package com.zenbank.cilm.dto;

import java.time.LocalDate;

public class CustomerNomineeResponseDto {

	private String nomineeId;
    private String verificationStatus;
    private String nomineeName;
    private String relationship;
    private String mobile;
    private LocalDate dob;
    private Double sharePercentage;

    public CustomerNomineeResponseDto() {
    }

    public CustomerNomineeResponseDto(String nomineeId,
                                      String verificationStatus,
                                      String nomineeName,
                                      String relationship,
                                      String mobile,
                                      LocalDate dob,
                                      Double sharePercentage) {
        this.nomineeId = nomineeId;
        this.verificationStatus = verificationStatus;
        this.nomineeName = nomineeName;
        this.relationship = relationship;
        this.mobile = mobile;
        this.dob = dob;
        this.sharePercentage = sharePercentage;
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

    public Double getSharePercentage() {
        return sharePercentage;
    }

    public void setSharePercentage(Double sharePercentage) {
        this.sharePercentage = sharePercentage;
    }
}