package com.zenbank.cilm.dto;

public class CustomerNomineeResponseDto {

    private String nomineeId;
    private String verificationStatus;

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

}
