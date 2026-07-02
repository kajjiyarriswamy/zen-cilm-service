package com.zenbank.cilm.dto;

public class CustomerNomineeResponseDto {
    private String status;
    private String message;
    private String nomineeId;
    private String verificationStatus;

    public CustomerNomineeResponseDto() {
    }

    public CustomerNomineeResponseDto(String status,
                                      String message,
                                      String nomineeId,
                                      String verificationStatus) {
        this.status = status;
        this.message = message;
        this.nomineeId = nomineeId;
        this.verificationStatus = verificationStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
