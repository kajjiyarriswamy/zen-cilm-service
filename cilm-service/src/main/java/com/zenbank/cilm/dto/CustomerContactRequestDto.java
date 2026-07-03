package com.zenbank.cilm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CustomerContactRequestDto {

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Pattern(regexp = "^[0-9]{10}$", message = "Alternate mobile must be 10 digits")
    private String alternateMobile;

    @Email(message = "Email should be valid")
    private String email;

    private String landline;

    @NotBlank(message = "Preferred contact mode is required")
    private String preferredContactMode;

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public String getAlternateMobile() { return alternateMobile; }
    public void setAlternateMobile(String alternateMobile) { this.alternateMobile = alternateMobile; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getLandline() { return landline; }
    public void setLandline(String landline) { this.landline = landline; }

    public String getPreferredContactMode() { return preferredContactMode; }
    public void setPreferredContactMode(String preferredContactMode) { this.preferredContactMode = preferredContactMode; }
}