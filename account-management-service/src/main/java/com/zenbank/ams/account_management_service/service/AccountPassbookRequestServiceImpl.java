package com.zenbank.ams.account_management_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenbank.ams.account_management_service.dto.CreatePassbookRequest;
import com.zenbank.ams.account_management_service.dto.DeliveryAddressDto;
import com.zenbank.ams.account_management_service.dto.PassbookRequestDetailsResponse;
import com.zenbank.ams.account_management_service.dto.PassbookRequestResponse;
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

		Account account=accountRepository.findById(accountId).orElseThrow(() ->
		     new ResourceNotFoundException("Account not found"));

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
}
