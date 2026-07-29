package com.zenbank.deposit_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.deposit_service.dto.UpdateDepositRequest;
import com.zenbank.deposit_service.dto.UpdateDepositResponse;
import com.zenbank.deposit_service.service.UpdateDepositTransactionService;

@RestController
@RequestMapping("/api/v1/deposits")
public class UpdateDepositTransactionController {
	
	@Autowired
	private UpdateDepositTransactionService service;
	
	@PutMapping("/{depositId}")
	public ResponseEntity<UpdateDepositResponse> getUpdateDeposit(
												@PathVariable Long depositId,
												@RequestBody UpdateDepositRequest request){
		UpdateDepositResponse response=service.getUpdateDepositResponse(depositId,request);
		return ResponseEntity.ok(response);
	}

}
