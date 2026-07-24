package com.zenbank.ams.account_management_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.ams.account_management_service.dto.CloseAccountRequestDto;
import com.zenbank.ams.account_management_service.dto.CloseAccountResponseDto;
import com.zenbank.ams.account_management_service.service.AccountClosureService;


@RestController
@RequestMapping("/api/v1/accounts")
public class AccountClosureController {
	
	@Autowired
	AccountClosureService accountClosureService;
	@PostMapping("/{accountId}/close")
	public ResponseEntity<CloseAccountResponseDto>closeAccount(@PathVariable Long accountId,
			@RequestBody CloseAccountRequestDto request){
		CloseAccountResponseDto response=accountClosureService.closeAccount(accountId, request);
		return ResponseEntity.ok(response);
	}
}
