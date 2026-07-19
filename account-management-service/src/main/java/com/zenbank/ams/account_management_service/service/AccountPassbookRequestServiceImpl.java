package com.zenbank.ams.account_management_service.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

import com.zenbank.ams.account_management_service.dto.CreatePassbookRequest;
import com.zenbank.ams.account_management_service.dto.DeliveryAddressDto;
import com.zenbank.ams.account_management_service.dto.PassbookRequestDetailsResponse;
import com.zenbank.ams.account_management_service.dto.PassbookRequestResponse;
import com.zenbank.ams.account_management_service.dto.SearchPassbookRequestResponse;
import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.entity.AccountPassbookRequest;
import com.zenbank.ams.account_management_service.exception.PassbookRequestException;
import com.zenbank.ams.account_management_service.exception.ResourceNotFoundException;
import com.zenbank.ams.account_management_service.repository.AccountPassbookRequestRepository;
import com.zenbank.ams.account_management_service.repository.AccountRepository;

@Service
public class AccountPassbookRequestServiceImpl implements AccountPassbookRequestService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountPassbookRequestRepository repository;

	@Override
	public PassbookRequestResponse createRequest(Long accountId, CreatePassbookRequest dto) {

		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new PassbookRequestException("PBK_002", "Account not found"));

		if (!"ACTIVE".equals(account.getAccountStatus())) {
			throw new PassbookRequestException("PBK_003", "Account is not ACTIVE");
		}

		List<String> activeStatus = List.of("REQUESTED", "APPROVED", "PRINTED", "READY_FOR_COLLECTION", "DISPATCHED");

		if (repository.existsByAccountAccountIdAndRequestStatusIn(accountId, activeStatus)) {

			throw new PassbookRequestException("PBK_001",
					"An active passbook request already exists for this account.");
		}

		if ("COURIER".equals(dto.getDeliveryMode()) && dto.getDeliveryAddress() == null) {

			throw new PassbookRequestException("PBK_004", "Delivery address is mandatory.");
		}

		AccountPassbookRequest entity = new AccountPassbookRequest();

		entity.setAccount(account);
		entity.setCustomerId(dto.getCustomerId());
		entity.setAccountNumber(dto.getAccountNumber());
		entity.setRequestType(dto.getRequestType());
		entity.setRequestMode(dto.getRequestMode());
		entity.setDeliveryMode(dto.getDeliveryMode());

		if (dto.getDeliveryAddress() != null) {

			DeliveryAddressDto address = dto.getDeliveryAddress();

			String fullAddress = address.getDoorNumber() + ", " + address.getStreet() + ", " + address.getArea() + ", "
					+ address.getCity() + ", " + address.getDistrict() + ", " + address.getState() + ", "
					+ address.getPostalCode() + ", " + address.getCountry();

			entity.setDeliveryAddress(fullAddress);
		}
		entity.setBranchCode(account.getBranchCode());

		entity.setRequestStatus("REQUESTED");

		entity.setRemarks(dto.getRemarks());

		entity.setCreatedBy("SYSTEM");

		entity.setUpdatedBy("SYSTEM");

		entity.setCreatedDate(LocalDateTime.now());

		entity.setUpdatedDate(LocalDateTime.now());

		repository.save(entity);

		PassbookRequestResponse response = new PassbookRequestResponse();

		response.setStatus("SUCCESS");

		response.setMessage("Passbook request created successfully.");

		response.setPassbookRequestId("PBR" + String.format("%06d", entity.getPassbookRequestId()));

		response.setRequestStatus("REQUESTED");

		return response;

	}

	@Override
	public PassbookRequestDetailsResponse getPassbookRequest(Long accountId, Long passbookRequestId) {

		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account not found"));

		AccountPassbookRequest request = repository
				.findByPassbookRequestIdAndAccountAccountId(passbookRequestId, accountId, account)
				.orElseThrow(() -> new PassbookRequestException("PBK_005", "Passbook request not found."));

		PassbookRequestDetailsResponse response = new PassbookRequestDetailsResponse();

		response.setStatus("SUCCESS");

		PassbookRequestDetailsResponse.PassbookRequestData data = new PassbookRequestDetailsResponse.PassbookRequestData();

		data.setPassbookRequestId("PBR" + String.format("%06d", request.getPassbookRequestId()));

		data.setAccountNumber(request.getAccountNumber());
		data.setRequestType(request.getRequestType());
		data.setRequestMode(request.getRequestMode());
		data.setDeliveryMode(request.getDeliveryMode());
		data.setRequestStatus(request.getRequestStatus());
		data.setCourierTrackingNumber(request.getCourierTrackingNumber());
		data.setDispatchDate(request.getDispatchDate());
		data.setDeliveryDate(request.getDeliveryDate());
		data.setRemarks(request.getRemarks());

		response.setData(data);

		return response;
	}

	@Override
	public PassbookRequestResponse updatePassbookRequest(Long accountId, Long passbookRequestId,
			CreatePassbookRequest requestDto) {

		AccountPassbookRequest passbookRequest = repository
				.findByPassbookRequestIdAndAccountAccountId(passbookRequestId, accountId)
				.orElseThrow(() -> new PassbookRequestException("PBK_005", "Passbook request not found"));
		if ("PRINTED".equals(passbookRequest.getRequestStatus())
				|| "READY_FOR_COLLECTION".equals(passbookRequest.getRequestStatus())
				|| "DISPATCHED".equals(passbookRequest.getRequestStatus())
				|| "DELIVERED".equals(passbookRequest.getRequestStatus())) {

			throw new PassbookRequestException("PBK_006", "Passbook request cannot be updated after printing.");
		}

		passbookRequest.setDeliveryMode(requestDto.getDeliveryMode());
		passbookRequest.setBranchCode(requestDto.getBranchCode());
		passbookRequest.setBranchName(requestDto.getBranchName());
		passbookRequest.setRemarks(requestDto.getRemarks());
		passbookRequest.setUpdatedBy("SYSTEM");
		passbookRequest.setUpdatedDate(LocalDateTime.now());

		repository.save(passbookRequest);
		PassbookRequestResponse response = new PassbookRequestResponse();
		response.setStatus("SUCCESS");
		response.setMessage("Passbook request updated successfully.");

		return response;
	}

	@Override
	public SearchPassbookRequestResponse searchPassbookRequest(String accountNumber, String customerId,
			String requestType, String requestStatus, String requestMode, String deliveryMode, String branchCode,
			LocalDate fromDate, LocalDate toDate, int page, int size) {

		Pageable pageable = PageRequest.of(page, size);

		Page<AccountPassbookRequest> result = repository.searchPassbookRequest(accountNumber, customerId, requestType,
				requestStatus, requestMode, deliveryMode, branchCode, fromDate, toDate, pageable);
		if (result.isEmpty()) {
			throw new PassbookRequestException("PBK_007", "No passbook requests found.");
		}

		SearchPassbookRequestResponse response = new SearchPassbookRequestResponse();

		response.setStatus("SUCCESS");
		response.setPage(result.getNumber());
		response.setSize(result.getSize());
		response.setTotalRecords(result.getTotalElements());

		List<SearchPassbookRequestResponse.PassbookRequestData> list = result.getContent().stream().map(request -> {

			SearchPassbookRequestResponse.PassbookRequestData data = new SearchPassbookRequestResponse.PassbookRequestData();

			// JIRA format: PBR100001
			data.setPassbookRequestId("PBR" + String.format("%06d", request.getPassbookRequestId() + 100000));

			data.setAccountNumber(request.getAccountNumber());

			data.setRequestType(request.getRequestType());

			data.setRequestStatus(request.getRequestStatus());

			data.setDeliveryMode(request.getDeliveryMode());

			return data; // <-- Important

		}).collect(Collectors.toList());

		response.setData(list);

		return response;
	}
}
