package com.zenbank.ams.account_management_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.ams.account_management_service.dto.CreatePassbookRequest;
import com.zenbank.ams.account_management_service.dto.PassbookRequestDetailsResponse;
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
		PassbookRequestResponse response = service.createRequest(accountId, request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

		
	}
	
	
	
	@GetMapping("/{accountId}/passbook-requests/{passbookRequestId}")
	public ResponseEntity<PassbookRequestDetailsResponse> getPassbookRequest(
			
			@PathVariable Long accountId,
			@PathVariable Long passbookRequestId){
		 
		PassbookRequestDetailsResponse response =
	            service.getPassbookRequest(accountId, passbookRequestId);

	    return ResponseEntity.ok(response);
	}
	
}
