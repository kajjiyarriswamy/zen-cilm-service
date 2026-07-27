package com.zenbank.deposit_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.deposit_service.dto.DepositResponse;
import com.zenbank.deposit_service.service.DepositTransactionService;

@RestController
@RequestMapping("api/v1/deposits")
public class DepositTransactionController {
	
	@Autowired
	private DepositTransactionService service;
	
	@GetMapping("/{depositId}")
	public ResponseEntity<DepositResponse> getDepositTransaction(@PathVariable Long depositId){
		DepositResponse response=service.getDepositTransactionDetails(depositId);
		return ResponseEntity.ok(response);
	}

}
