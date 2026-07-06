package com.zenbank.cilm.dto;

import java.time.LocalDate;

import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerNominee;

import java.time.LocalDate;

public class CustomerResponseDto {


    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String accountNumber;

    private Long nomineeId;
    private String customerId;
    private String nomineeName;
    private String relationship;
    private String verificationStatus;
    private LocalDate dob;
    private String mobile;
    private Double sharePercentage;

    private String cif_number;
    private LocalDate createdDate;



	    public CustomerResponseDto() {
	    }

	    public CustomerResponseDto(Long id, String firstName, String lastName, String email, String phoneNumber, String accountNumber) {
	        this.id = id;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.phoneNumber = phoneNumber;
	        this.accountNumber = accountNumber;
	    }


    public CustomerResponseDto(Long id, String firstName, String lastName, String email, String phoneNumber, String accountNumber, String cif_number, LocalDate createdDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accountNumber = accountNumber;
        this.cif_number = cif_number;
        this.createdDate = createdDate;
    }

    public CustomerResponseDto(Long nomineeId, 
    		String nomineeName, 
    		String mobile, 
    		String relationship,
			String customer, 
			Double sharePercentage, LocalDate dob) {
		
    	this.nomineeId=nomineeId;
    	this.nomineeName=nomineeName;
    	this.mobile=mobile;
    	this.relationship=relationship;
    	this.customerId=customer;
    	this.sharePercentage=sharePercentage;
    	this.dob=dob;
	}

	public static CustomerResponseDto fromEntity(Customer customer) {
        CustomerResponseDto response = new CustomerResponseDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                customer.getAccountNumber(),
                customer.getCif_number(),
                customer.getCreatedDate()
        );
        response.setCustomerId(customer.getCustomerId());
        return response;
    }



	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}
    
	public Long getNomineeId() {
		return nomineeId;
	}

	public void setNomineeId(Long nomineeId) {
		this.nomineeId = nomineeId;
	}

	

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
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

	public static CustomerResponseDto fromEntity(CustomerNominee savedCustomer) {
	
		return new CustomerResponseDto(
				savedCustomer.getNomineeId(),
				savedCustomer.getNomineeName(),
				savedCustomer.getMobile(),
				savedCustomer.getRelationship(),
				savedCustomer.getCustomerId().getCustomerId(),
				savedCustomer.getSharePercentage(),
				savedCustomer.getDob()
				);
				
	}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		public String getCif_number() {
			return cif_number;
		}

		public void setCif_number(String cif_number) {
			this.cif_number = cif_number;
		}

		public LocalDate getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(LocalDate createdDate) {
			this.createdDate = createdDate;
		}
	    
	    
	    

}

	    
