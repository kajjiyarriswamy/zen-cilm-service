package com.zenbank.cilm.service;

import com.zenbank.cilm.Enum.CustomerStatus;

import com.zenbank.cilm.dto.CustomerPreferenceResponseDto;

import com.zenbank.cilm.dto.CustomerDetailsResponseDto;

import com.zenbank.cilm.dto.CustomerRequestDto;
import com.zenbank.cilm.dto.CustomerResponseDto;
import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerAudit;
import com.zenbank.cilm.entity.CustomerPreference;
import com.zenbank.cilm.repository.CustomerRepository;

import com.zenbank.cilm.dto.CustomerContactRequestDto;
import com.zenbank.cilm.dto.CustomerContactResponseDto;
import com.zenbank.cilm.entity.CustomerContact;
import com.zenbank.cilm.repository.CustomerContactRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import com.zenbank.cilm.repository.CustomerAuditRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;
	private final CustomerContactRepository customerContactRepository;
	private final CustomerAuditRepository customerAuditRepository;

	private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

	public CustomerService(CustomerRepository customerRepository,
	                       CustomerContactRepository customerContactRepository,
	                       CustomerAuditRepository customerAuditRepository) {
		this.customerRepository = customerRepository;
		this.customerContactRepository = customerContactRepository;
		this.customerAuditRepository = customerAuditRepository;
	}

	public CustomerResponseDto createCustomer(CustomerRequestDto requestDto) {
		if (customerRepository.existsByPanNumber(requestDto.getPanNumber())) {
			throw new IllegalArgumentException("PAN Number already exists.");
		}

		if (customerRepository.existsByAadhaarNumber(requestDto.getAadhaarNumber())) {
			throw new IllegalArgumentException("Aadhaar Number already exists.");
		}

		if (customerRepository.existsByPhoneNumber(requestDto.getPhoneNumber())) {
			throw new IllegalArgumentException("Mobile Number already exists.");
		}

		int age = Period.between(requestDto.getDateOfBirth(), LocalDate.now()).getYears();

		if (age < 18) {
			throw new IllegalArgumentException("Customer age should be 18 years or above.");
		}
		Optional<Customer> existing = customerRepository.findByEmail(requestDto.getEmail());

		if (existing.isPresent()) {
			throw new IllegalArgumentException("Customer with this email already exists");
		}

		Customer customer = new Customer();

		Random random = new Random();
		customer.setCif_number("CIF" + String.valueOf(10000000 + random.nextInt(90000000)));
		customer.setFirstName(requestDto.getFirstName());
		customer.setMiddleName(requestDto.getMiddleName());
		customer.setLastName(requestDto.getLastName());
		customer.setAge(requestDto.getAge());
		customer.setDateOfBirth(requestDto.getDateOfBirth());
		customer.setGender(requestDto.getGender());
		customer.setMaritalStatus(requestDto.getMaritalStatus());
		customer.setOccupation(requestDto.getOccupation());
		customer.setAnnalIncome(requestDto.getAnnualIncome());
		customer.setCustomerType(requestDto.getCustomerType());
		customer.setCustomerCategory(requestDto.getCustomerCategory());
		customer.setEmail(requestDto.getEmail());
		customer.setPhoneNumber(requestDto.getPhoneNumber());
		customer.setAadhaarNumber(requestDto.getAadhaarNumber());
		customer.setPanNumber(requestDto.getPanNumber());
		customer.setNationality(requestDto.getNationality());
		customer.setAccountNumber("SBI-" + String.valueOf(10000000 + random.nextInt(90000000)));
		customer.setCreatedDate(LocalDate.now());

		Customer savedCustomer = customerRepository.save(customer);
		return CustomerResponseDto.fromEntity(savedCustomer);
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

	public CustomerContactResponseDto addContact(String customerId, CustomerContactRequestDto requestDto) {

		Customer customer = customerRepository.findByCustomerId(customerId)
				.orElseThrow(() -> new IllegalArgumentException("Customer does not exist."));

		if (customerContactRepository.existsByMobileNumber(requestDto.getMobileNumber())) {
			throw new IllegalArgumentException("Mobile number already exists.");
		}

		if (requestDto.getAlternateMobile() != null &&
				requestDto.getAlternateMobile().equals(requestDto.getMobileNumber())) {
			throw new IllegalArgumentException("Alternate mobile cannot be the same as primary mobile.");
		}

		if (requestDto.getEmail() != null &&
				customerContactRepository.existsByEmail(requestDto.getEmail())) {
			throw new IllegalArgumentException("Email already exists.");
		}

		String[] validModes = {"SMS", "EMAIL", "PHONE"};
		boolean validMode = false;
		for (String mode : validModes) {
			if (mode.equals(requestDto.getPreferredContactMode())) {
				validMode = true;
				break;
			}
		}
		if (!validMode) {
			throw new IllegalArgumentException("Preferred contact mode must be SMS, EMAIL or PHONE.");
		}

		CustomerContact contact = new CustomerContact();
		contact.setCustomer(customer);
		contact.setMobileNumber(requestDto.getMobileNumber());
		contact.setAlternateMobile(requestDto.getAlternateMobile());
		contact.setEmail(requestDto.getEmail());
		contact.setLandline(requestDto.getLandline());
		contact.setPreferredContactMode(requestDto.getPreferredContactMode());

		CustomerContact saved = customerContactRepository.save(contact);

		String contactId = "CNT" + String.format("%06d", saved.getContactId());

		return new CustomerContactResponseDto(
				"SUCCESS",
				"Customer contact details added successfully.",
				contactId,
				customerId
		);
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
		}).collect(Collectors.toList());

		Map<String, Object> response = new LinkedHashMap<>();
		response.put("status", "SUCCESS");
		response.put("page", page);
		response.put("size", size);
		response.put("totalRecords", results.getTotalElements());
		response.put("auditHistory", auditHistory);
		return response;
	}

}
