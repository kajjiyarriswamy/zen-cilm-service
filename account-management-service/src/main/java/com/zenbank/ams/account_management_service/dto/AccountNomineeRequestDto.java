package com.zenbank.ams.account_management_service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

//import jakarta.validation.constraints.DecimalMax;
//import jakarta.validation.constraints.DecimalMin;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Past;
//import jakarta.validation.constraints.Pattern;

public class AccountNomineeRequestDto {

   
    private String nomineeName;

    
    private String relationship;

  //  @NotBlank(message = "Mobile number is mandatory")
 //   @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid mobile number")
    private String mobileNumber;

 //   @NotNull(message = "Date of birth is mandatory")
//    @Past(message = "Date of birth cannot be a future date")
    private LocalDate dob;

   // @NotNull(message = "Share percentage is mandatory")
   // @DecimalMin(value = "0.01", message = "Share percentage must be greater than 0")
  //  @DecimalMax(value = "100.00", message = "Share percentage cannot exceed 100")
    private BigDecimal sharePercentage;

    public AccountNomineeRequestDto() {
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public BigDecimal getSharePercentage() {
        return sharePercentage;
    }

    public void setSharePercentage(BigDecimal sharePercentage) {
        this.sharePercentage = sharePercentage;
    }


}
