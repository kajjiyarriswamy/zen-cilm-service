package com.zenbank.ams.account_management_service.controller;

import java.security.Provider.Service;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.ams.account_management_service.dto.CreatePassbookRequest;
import com.zenbank.ams.account_management_service.dto.PassbookRequestDetailsResponse;
import com.zenbank.ams.account_management_service.dto.PassbookRequestResponse;
import com.zenbank.ams.account_management_service.dto.SearchPassbookRequestResponse;
import com.zenbank.ams.account_management_service.dto.UpdateNicknameRequest;
import com.zenbank.ams.account_management_service.service.AccountPassbookRequestService;
import com.zenbank.ams.account_management_service.service.AccountServiceI;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountPassbookRequestController {
	@Autowired
	private AccountPassbookRequestService service;

	@PostMapping("/{accountId}/passbook-requests")
	public ResponseEntity<PassbookRequestResponse> create(

			@PathVariable Long accountId,

			@RequestBody CreatePassbookRequest request) {
		PassbookRequestResponse response = service.createRequest(accountId, request);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

	@GetMapping("/{accountId}/passbook-requests/{passbookRequestId}")
	public ResponseEntity<PassbookRequestDetailsResponse> getPassbookRequest(

			@PathVariable Long accountId, @PathVariable Long passbookRequestId) {

		PassbookRequestDetailsResponse response = service.getPassbookRequest(accountId, passbookRequestId);

		return ResponseEntity.ok(response);
	}

	@PutMapping("/{accountId}/passbook-requests/{passbookRequestId}")
	public ResponseEntity<PassbookRequestResponse> updatePassbookRequest(@PathVariable Long accountId,
			@PathVariable Long passbookRequestId, @RequestBody CreatePassbookRequest request) {

		PassbookRequestResponse response = service.updatePassbookRequest(accountId, passbookRequestId, request);

		return ResponseEntity.ok(response);
	}

	@GetMapping("/passbook-requests/search")
	public ResponseEntity<SearchPassbookRequestResponse> searchPassbookRequests(

			@RequestParam(required = false) String accountNumber, @RequestParam(required = false) String customerId,
			@RequestParam(required = false) String requestType, @RequestParam(required = false) String requestStatus,
			@RequestParam(required = false) String requestMode, @RequestParam(required = false) String deliveryMode,
			@RequestParam(required = false) String branchCode, @RequestParam(required = false) LocalDate fromDate,
			@RequestParam(required = false) LocalDate toDate, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {

		return ResponseEntity.ok(service.searchPassbookRequest(accountNumber, customerId, requestType, requestStatus,
				requestMode, deliveryMode, branchCode, fromDate, toDate, page, size));
	}
	
	@PutMapping("/{accountId}/nickname")
	public ResponseEntity<PassbookRequestResponse> updateNickname(
			@PathVariable Long accountId,
			@RequestBody UpdateNicknameRequest request){
				PassbookRequestResponse response= service.updateNickname(accountId, request);
				return ResponseEntity.ok(response);
	}

}
