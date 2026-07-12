package com.zenbank.cilm.dto;

import java.time.LocalDateTime;

public class CustomerKycRequestDto {

	 private Boolean panVerified;
	    private Boolean aadhaarVerified;
	    private String kycStatus;
	    private String verifiedBy;
	    private LocalDateTime verifiedDate;
		public Boolean getPanVerified() {
			return panVerified;
		}
		public void setPanVerified(Boolean panVerified) {
			this.panVerified = panVerified;
		}
		public Boolean getAadhaarVerified() {
			return aadhaarVerified;
		}
		public void setAadhaarVerified(Boolean aadhaarVerified) {
			this.aadhaarVerified = aadhaarVerified;
		}
		public String getKycStatus() {
			return kycStatus;
		}
		public void setKycStatus(String kycStatus) {
			this.kycStatus = kycStatus;
		}
		public String getVerifiedBy() {
			return verifiedBy;
		}
		public void setVerifiedBy(String verifiedBy) {
			this.verifiedBy = verifiedBy;
		}
		public LocalDateTime getVerifiedDate() {
			return verifiedDate;
		}
		public void setVerifiedDate(LocalDateTime verifiedDate) {
			this.verifiedDate = verifiedDate;
		}
	    
	    
}
