package com.zenbank.ams.account_management_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.ams.account_management_service.dto.CreatePassbookRequest;
import com.zenbank.ams.account_management_service.dto.PassbookRequestResponse;
import com.zenbank.ams.account_management_service.service.AccountPassbookRequestService;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountPassbookRequestController {
	@Autowired
	private AccountPassbookRequestService service;

	@PostMapping("/{accountId}/passbook-requests")
	public ResponseEntity<PassbookRequestResponse> create(

			@PathVariable Long accountId,

			@RequestBody CreatePassbookRequest request) {

		return new ResponseEntity<>(service.createRequest(accountId, request), HttpStatus.CREATED);
	}
}
