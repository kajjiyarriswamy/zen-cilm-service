package com.zenbank.cilm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerContactResponseDto {

    private String contactId;
    private String mobileNumber;
    private String alternateMobile;
    private String email;
    private String landline;
    private String preferredContactMode;

    public CustomerContactResponseDto() {
    }

    public CustomerContactResponseDto(String contactId, String mobileNumber,
            String alternateMobile, String email,
            String landline, String preferredContactMode) {
        this.contactId = contactId;
        this.mobileNumber = mobileNumber;
        this.alternateMobile = alternateMobile;
        this.email = email;
        this.landline = landline;
        this.preferredContactMode = preferredContactMode;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
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

    public String getPreferredContactMode() {
        return preferredContactMode;
    }

    public void setPreferredContactMode(String preferredContactMode) {
        this.preferredContactMode = preferredContactMode;
    }
}