package com.zenbank.cilm.service;

import com.zenbank.cilm.dto.AddressResponseDto;
import com.zenbank.cilm.dto.CustomerGetRequestDto;
import com.zenbank.cilm.dto.CustomerRequestDto;
import com.zenbank.cilm.dto.CustomerResponseDto;
import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerAddress;
import com.zenbank.cilm.entity.CustomerAudit;
import com.zenbank.cilm.repository.AddressRepository;
import com.zenbank.cilm.repository.CustomerAuditRepository;
import com.zenbank.cilm.entity.CustomerNominee;
import com.zenbank.cilm.dto.*;
import com.zenbank.cilm.entity.*;
import com.zenbank.cilm.repository.CustomerNomineeRepository;

import com.zenbank.cilm.Enum.CustomerStatus;

import com.zenbank.cilm.repository.CustomerRepository;

import com.zenbank.cilm.repository.CustomerContactRepository;
import com.zenbank.cilm.repository.CustomerKycRepository;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
public class CustomerService {


	private final CustomerRepository customerRepository;
	private final CustomerNomineeRepository customerNomineeRepository;
	private final AddressRepository customerAddressRepository;

	private final CustomerKycRepository customerKycRepository;
	private final CustomerAuditRepository customerAuditRepository;
	private final CustomerContactRepository customerContactRepository;
	

    public CustomerService(CustomerRepository customerRepository, CustomerNomineeRepository customerNomineeRepository,AddressRepository customerAddressRepository,CustomerKycRepository customerKycRepository,CustomerContactRepository customerContactRepository,
            CustomerAuditRepository customerAuditRepository) {
        this.customerRepository = customerRepository;
        this.customerNomineeRepository = customerNomineeRepository;
		this.customerAddressRepository = customerAddressRepository;
		this. customerKycRepository=customerKycRepository;
		this.customerContactRepository = customerContactRepository;
		this.customerAuditRepository = customerAuditRepository;
    }

	

	

	@Transactional
	public CustomerResponseDto createCustomer(CustomerRequestDto dto) {
		Optional<Customer> existing = customerRepository.findByEmail(dto.getEmail());
		if (existing.isPresent()) {
			throw new IllegalArgumentException("Customer with this email already exists");
		}

		Customer cu = new Customer();
		cu.setCif_number(dto.getCif_number());
		cu.setFirstName(dto.getFirstName());
		cu.setMiddleName(dto.getMiddleName());
		cu.setLastName(dto.getLastName());
		cu.setDateOfBirth(dto.getDateOfBirth());
		cu.setGender(dto.getGender());
		cu.setMaritalStatus(dto.getMaritalStatus());
		cu.setOccupation(dto.getOccupation());
		cu.setAnnalIncome(dto.getAnnualIncome());
		cu.setCustomerType(dto.getCustomerType());
		cu.setCustomerCategory(dto.getCustomerCategory());
		cu.setPanNumber(dto.getPanNumber());
		cu.setAadhaarNumber(dto.getAadhaarNumber());
		cu.setNationality(dto.getNationality());
		cu.setCustomerStatus(dto.getCustomerStatus());
		cu.setRiskCategory(dto.getRiskCategory());
		cu.setCreatedDate(LocalDate.now());
		cu.setUpdatedDate(LocalDate.now());
		cu.setEmail(dto.getEmail());
		cu.setPhoneNumber(dto.getPhoneNumber());
		cu.setAccountNumber(dto.getAccountNumber());
		cu.setAge(dto.getAge());
		cu.setCustomerId(generateCustomerId());

//        Customer customer=customerRepository.findById(dto.getCustomerId())
//        		.orElseThrow(() -> new RuntimeException("Customer Not Found"));
//        CustomerNominee cn=new CustomerNominee();
//
//
//        cn.setCustomerId(customer);
//        cn.setNomineeName(dto.getNomineeName());
//        cn.setRelationship(dto.getRelationship());
//        cn.setDob(dto.getDob());
//        cn.setMobile(dto.getMobile());
//        cn.setSharePercentage(dto.getSharePercentage());
//        cn.setVerificationStatus(dto.getVerificationStatus());

		Customer savedCustomer = customerRepository.save(cu);


//        CustomerNominee savedCustomer = customerNomineeRepository.save(cn);
		return CustomerResponseDto.fromEntity(savedCustomer);
	}

	private String generateCustomerId() {
		return customerRepository.findTopByOrderByCustomerIdDesc()
				.map(Customer::getCustomerId)
				.map(this::incrementCustomerId)
				.orElse("CUS100001");
	}

	private String incrementCustomerId(String currentCustomerId) {
		final String prefix = "CUS";
		if (currentCustomerId == null || !currentCustomerId.startsWith(prefix)) {
			return "CUS100001";
		}

		String numericPart = currentCustomerId.substring(prefix.length());
		int nextNumber = Integer.parseInt(numericPart) + 1;
		return prefix + String.format("%06d", nextNumber);
	}


	public List<CustomerResponseDto> getAllCustomers() {
		return customerRepository.findAll().stream().map(CustomerResponseDto::fromEntity).toList();
	}

	public Optional<CustomerResponseDto> getCustomerById(Long id) {
		return customerRepository.findById(id).map(CustomerResponseDto::fromEntity);
	}


	public void updateCustomerStatus(Long customerId, CustomerStatus status) {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));

		customer.setCustomerStatus(status);

		customerRepository.save(customer);
	}

	public CustomerDetailsResponseDto getCustomerDetails(String customerId) {
		Customer customer = customerRepository.findByCustomerId(customerId)
				.orElseThrow(() -> new IllegalArgumentException("Customer not found: " + customerId));
		return CustomerDetailsResponseDto.fromEntity(customer);
	}

	public Map<String, Object> searchCustomer(Long customerId, String cif, String phoneNumber, String pan,
	                                          String aadhaar, String status, int page, int size) {

		Pageable pageable = PageRequest.of(page, size);

		Page<Customer> customerPage = customerRepository.searchCustomer(customerId, cif, phoneNumber, pan, aadhaar,
				status, pageable);

		List<CustomerResponseDto> customers = customerPage.getContent().stream().map(CustomerResponseDto::fromEntity)
				.toList();

		Map<String, Object> response = new LinkedHashMap<>();

		response.put("content", customers);
		response.put("page", customerPage.getNumber());
		response.put("size", customerPage.getSize());
		response.put("totalElement", customerPage.getTotalElements());

		return response;
	}

	public Map<String, Object> getCustomerAddresses(Long customerId) {

		Optional<Customer> customer = customerRepository.findById(customerId);

		Map<String, Object> response = new LinkedHashMap<>();

		if (customer.isEmpty()) {
			response.put("status", "FAILED");
			response.put("message", "Customer not found.");
			return response;
		}

		List<CustomerAddress> addressList = customerAddressRepository.findByCustomer_Id(customerId);

		List<AddressResponseDto> addresses = addressList.stream().map(address -> {

			AddressResponseDto dto = new AddressResponseDto();

			dto.setAddressId(address.getAddressId());
			dto.setAddressType(address.getAddressType().name());
			dto.setDoorNumber(address.getDoorDumber());
			dto.setStreet(address.getStreet());
			dto.setCity(address.getCity());
			dto.setState(address.getState());
			dto.setCountry(address.getCountry());
			dto.setPostalCode(address.getPostalCode());
			dto.setPrimary(address.isPrimary());
			dto.setCustomerId(address.getCustomer().getCustomerId());

			return dto;
		}).toList();

		response.put("status", "SUCCESS");
		response.put("addresses", addresses);

		return response;
	}

	public Map<String, Object> deleteCustomerAddress(Long customerId, Long addressId) {

		Map<String, Object> response = new LinkedHashMap<>();

		Optional<Customer> customer = customerRepository.findById(customerId);

		if (customer.isEmpty()) {

			response.put("status", "FAILED");
			response.put("message", "Customer not found.");
			return response;
		}

		Optional<CustomerAddress> address = customerAddressRepository.findById(addressId);

		if (address.isEmpty()) {

			response.put("status", "FAILED");
			response.put("message", "Address not found.");
			return response;
		}

		CustomerAddress customerAddress = address.get();

		if (customerAddress.isPrimary()) {

			response.put("status", "FAILED");
			response.put("errorCode", "ADDR_003");
			response.put("message", "Primary address cannot be deleted.");

			return response;
		}

		customerAddressRepository.delete(customerAddress);

		CustomerAudit audit = new CustomerAudit();

		audit.setCustomer(customer.get());
		audit.setAction("DELETE");
		audit.setPerformedBy("SYSTEM");
		audit.setOldValue("Address Deleted");
		audit.setNewValue(null);


		response.put("status", "SUCCESS");
		response.put("message", "Customer address deleted successfully.");

		return response;

	}


	public void updateNominee(Long customerId,
	                          Long nomineeId,
	                          CustomerRequestDto dto) {

		Customer customer=customerRepository.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Customer Not Found"));

		CustomerNominee nominee=customerNomineeRepository.findByNomineeIdAndCustomerId(nomineeId, customer)
				.orElseThrow(() -> new RuntimeException("Nominee Not Found"));

//		nominee.setMobile(dto.getMobile());
//		nominee.setSharePercentage(dto.getSharePercentage());

		customerNomineeRepository.save(nominee);


	}


	public CustomerPreferenceResponseDto getCustomerPreference(Long customerId) {

		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Customer not found"));

		CustomerPreference preference = customer.getCustomerPreference();

		if (preference == null) {
			throw new RuntimeException("Customer preferences not found.");
		}
		String preferenceId = "PREF" + String.format("%06d", preference.getPreferenceId());

		return new CustomerPreferenceResponseDto(preferenceId, preference.getLanguage(),
				preference.getCommunicationMode(), preference.getEmailEnabled(), preference.getSmsEnabled(),
				preference.getMarketingEnabled());
	}

	public CustomerPreference createPreference(Long customerId, CustomerPreference preference) {

		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Customer not found"));

		preference.setCustomer(customer);

		customer.setCustomerPreference(preference);



		customerRepository.save(customer);

		return customer.getCustomerPreference();
	}
	
	public void updateCustomer(Long customerId, CustomerRequestDto requestDto) {
		Customer customer = customerRepository.findById(customerId)
	            .orElseThrow(() -> new RuntimeException("Customer not found"));

	    customer.setOccupation(requestDto.getOccupation());
	    customer.setAnnalIncome(requestDto.getAnnualIncome());
	    customer.setMaritalStatus(requestDto.getMaritalStatus());

	    customerRepository.save(customer);
	}

	
	public void updateNotificationPreferences(Long customerId,
	                                          CustomerPreference request) {

// Check customer exists
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Customer not found"));

// Check preference exists
		CustomerPreference preference = customer.getCustomerPreference();

		if (preference == null) {
			throw new RuntimeException("Customer preferences not found.");
		}

// Update only notification fields
		preference.setEmailEnabled(request.getEmailEnabled());
		preference.setSmsEnabled(request.getSmsEnabled());

// Save
		customerRepository.save(customer);
	}
	

	public CustomerContactResponseDto addContact(String customerId, @Valid CustomerContactRequestDto requestDto) {

		return null;
	}

	/**public AddressResponseDto addAddress(Long customerId, AddressRequestDto requestDto) {
	
		Customer customer =  customerRepository.findByCustomerId(String.valueOf(customerId))

		Customer customer = customerRepository.findByCustomerId(customerId)

				.orElseThrow(() ->
						new RuntimeException("Customer not found"));

		CustomerContact customerContact = new CustomerContact();
		customerContact.setCustomer(customer);
		customerContact.setMobileNumber(requestDto.getMobileNumber());
		customerContact.setMobileNumber(requestDto.getMobileNumber());
		customerContact.setAlternateMobile(requestDto.getAlternateMobile());
		customerContact.setLandline(requestDto.getLandline());
		customerContact.setPreferredContactMode(requestDto.getPreferredContactMode());

		if (customer.getEmail() == null || customer.getEmail().isBlank()) {
			customerContact.setEmail(requestDto.getEmail());
		} else {
			customerContact.setEmail(customer.getEmail());
		}

		customerContactRepository.save(customerContact);

		return new CustomerContactResponseDto(
				"SUCCESS",
				"Contact added successfully.",
				"CNT10001",
				customer.getCustomerId()
		);
	}*/


	
	public CustomerKycResponseDto getCustomerKyc(Long customerId) {

	    Customer customer = customerRepository.findById(customerId)
	            .orElseThrow(() -> new RuntimeException("Customer not found"));

	    CustomerKyc customerKyc = customerKycRepository.findByCustomer(customer)
	            .orElseThrow(() -> new RuntimeException("KYC record not found."));

	    return new CustomerKycResponseDto(
	            customer.getCustomerId(),
	            customerKyc.getPanVerified(),
	            customerKyc.getAadhaarVerified(),
	            customerKyc.getKycStatus(),
	            customerKyc.getVerifiedBy(),
	            customerKyc.getVerifiedDate()
	    );
	}


	/**public Map<String, Object> searchAudit(String customerId, String action,
	                                       String performedBy, String fromDate,
	                                       String toDate, int page, int size) {*/


public AddressResponseDto addAddress(String customerId, AddressRequestDto requestDto)
{
	Customer customer =  customerRepository.findByCustomerId(customerId)
			.orElseThrow(() ->
					new RuntimeException("customer not found"));

	if (requestDto.getCountry() == null || requestDto.getCountry().isBlank()) {
		throw new RuntimeException("Country cannot be null");
	}

	if (!requestDto.getPostalCode().matches("\\d{6}")) {
		throw new RuntimeException("Invalid Postal Code");
	}

	if (Boolean.TRUE.equals(requestDto.getPrimary())) {

		boolean exists = customerAddressRepository
				.existsByCustomerAndIsPrimaryTrue(customer);

		if (exists) {
			throw new RuntimeException("Primary Address already exists");
		}
	}


	CustomerAddress customerAddress = new CustomerAddress();
	customerAddress.setCustomer(customer);
	customerAddress.setAddressType(requestDto.getAddressType());
	customerAddress.setDoorNumber(requestDto.getDoorNumber());
	customerAddress.setStreet(requestDto.getStreet());
	customerAddress.setArea(requestDto.getArea());
	customerAddress.setCity(requestDto.getCity());
	customerAddress.setDistrict(requestDto.getDistrict());
	customerAddress.setState(requestDto.getState());
	customerAddress.setCountry(requestDto.getCountry());
	customerAddress.setPostalCode(requestDto.getPostalCode());
	customerAddress.setPrimary(requestDto.getPrimary());

	customerAddressRepository.save(customerAddress);

	AddressResponseDto response = new AddressResponseDto();
	response.setStatus("SUCCESS");
	response.setMessage("Customer address added successfully.");
	response.setAddressId(customerAddress.getAddressId());
	response.setCustomerId(customer.getCustomerId());

	return response;
}


public Map<String, Object> searchAudit(String customerId, String action,
                                       String performedBy, String fromDate,
                                       String toDate, int page, int size) {

	customerRepository.findByCustomerId(customerId)
			.orElseThrow(() -> new IllegalArgumentException("Customer does not exist."));

	LocalDateTime from = fromDate != null ? LocalDate.parse(fromDate).atStartOfDay() : null;
	LocalDateTime to = toDate != null ? LocalDate.parse(toDate).atTime(23, 59, 59) : null;

	if (from != null && to != null && from.isAfter(to)) {
		throw new IllegalArgumentException("fromDate cannot be after toDate.");
	}

	Page<CustomerAudit> results = customerAuditRepository.searchAudit(
			customerId, action, performedBy, from, to, PageRequest.of(page, size));

	if (results.isEmpty()) {
		throw new IllegalArgumentException("No records found.");
	}

	List<Map<String, Object>> auditHistory = results.getContent().stream().map(a -> {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("auditId", "AUD" + String.format("%06d", a.getAuditId()));
		map.put("action", a.getAction());
		map.put("performedBy", a.getPerformedBy());
		map.put("createdDate", a.getCreatedDate());
		return map;
	}).collect(java.util.stream.Collectors.toList());

	Map<String, Object> response = new LinkedHashMap<>();
	response.put("status", "SUCCESS");
	response.put("page", page);
	response.put("size", size);
	response.put("totalRecords", results.getTotalElements());
	response.put("auditHistory", auditHistory);
	return response;
}

public Map<String, Object> getAuditDetails(String customerId, String auditId) {

	customerRepository.findByCustomerId(customerId)
			.orElseThrow(() -> new IllegalArgumentException("Customer does not exist."));

	Long auditIdNumeric = Long.parseLong(auditId.replace("AUD", ""));

	CustomerAudit audit = customerAuditRepository.findByAuditIdAndCustomer_CustomerId(auditIdNumeric, customerId)
			.orElseThrow(() -> new IllegalArgumentException("Audit record not found."));

	Map<String, Object> response = new LinkedHashMap<>();
	response.put("status", "SUCCESS");
	response.put("auditId", "AUD" + String.format("%06d", audit.getAuditId()));
	response.put("action", audit.getAction());
	response.put("performedBy", audit.getPerformedBy());
	response.put("createdDate", audit.getCreatedDate());
	response.put("oldValue", audit.getOldValue());
	response.put("newValue", audit.getNewValue());
	return response;
}

	public CustomerContactResponseDto updateMobileNumber(
			String customerId, CustomerContactRequestDto contactRequestDto) {
		// Find customer
		Customer customer = customerRepository.findByCustomerId(customerId)
				.orElseThrow(() ->
						new RuntimeException("Customer not found"));

		// Find customer contact
		CustomerContact customerContact = customerContactRepository
				.findByCustomer(customer)
				.orElseThrow(() ->
						new RuntimeException("Contact not found"));

		String mobile = contactRequestDto.getMobileNumber();
		if(mobile == null || mobile.isBlank()) {
			throw new RuntimeException("Mobile number cannot be null");
		}

		if(!mobile.matches("\\d{10}")){
			throw new RuntimeException("Invalid Mobile Number");
		}

		if (mobile.equals(customerContact.getMobileNumber())) {
			throw new RuntimeException("New mobile number must be different from the existing mobile number.");
		}

		if (customerContactRepository.existsByMobileNumber(mobile)) {
			throw new RuntimeException("Mobile number already exists");
		}

		// Verification
		boolean verified = true;
		if(!verified){
			throw new RuntimeException("Customer verification failed");
		}

		//Store the old mobile number before updating it.
		String oldMobileNumber = customerContact.getMobileNumber();

		// Update mobile number
		customerContact.setMobileNumber(mobile);
		customerContactRepository.save(customerContact);


		CustomerAudit customerAudit = new CustomerAudit();
		customerAudit.setCustomer(customer);
		customerAudit.setAction("MOBILE_UPDATED");
		customerAudit.setPerformedBy("BANK_EMPLOYEE");
		customerAudit.setOldValue(oldMobileNumber);
		customerAudit.setNewValue(mobile);

		customerAuditRepository.save(customerAudit);

//		notificationService.publishMobileUpdate(customer);

		CustomerContactResponseDto response = new CustomerContactResponseDto();
		response.setStatus("SUCCESS");
		response.setMessage("Mobile number updated successfully.");
		response.setCustomerId(customer.getCustomerId());
		response.setContactId(String.valueOf(customerContact.getContactId()));

		return response;

	}
	
//	get customer contact Details
	
	public Map<String, Object> getContactsByCustomerId(String customerId) {
		Map<String, Object> response = new LinkedHashMap<>();


		Optional<Customer> customer = customerRepository.findByCustomerId(customerId);

		if (customer.isEmpty()){
			response.put("status", "FAILED");
			response.put("message", "Customer not found.");
			return response;
		}

		List<CustomerContact> contacts =
				customerContactRepository.findByCustomerCustomerId(customerId);

		List<CustomerContact> ResponseDtoList = new ArrayList<>();
		for (CustomerContact contact : contacts) {

			CustomerContact responseDto = new CustomerContact();

			responseDto.setContactId(contact.getContactId());
			responseDto.setMobileNumber(contact.getMobileNumber());
			responseDto.setAlternateMobile(contact.getAlternateMobile());
			responseDto.setEmail(contact.getEmail());
			responseDto.setLandline(contact.getLandline());
			responseDto.setPreferredContactMode(contact.getPreferredContactMode());

			ResponseDtoList.add(responseDto);
		}
		response.put("status", "SUCCESS");
		response.put("message", "Contacts fetched successfully.");
		response.put("data", ResponseDtoList);

		return response;

	}



	
	
	}
