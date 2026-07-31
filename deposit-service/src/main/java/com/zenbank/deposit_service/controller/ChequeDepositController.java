package com.zenbank.deposit_service.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.deposit_service.dto.ChequeDepositSearchResponse;
import com.zenbank.deposit_service.service.ChequeDepositService;

@RestController
@RequestMapping("/api/v1/deposits")
public class ChequeDepositController {
	
	@Autowired
	private ChequeDepositService chequeDepositService;
	
	@GetMapping("/cheque")
	public ResponseEntity<ChequeDepositSearchResponse> searchChequeDeposits(
			
			@RequestParam(required = false) Long chequeDepositId,
			@RequestParam(required = false) String chequeNumber,
			@RequestParam(required = false) Long customerId,
			@RequestParam(required = false) Long accountId,
			@RequestParam(required = false) String issuingBank,
			@RequestParam(required = false) String ifscCode,
			@RequestParam(required = false) String chequeStatus,
			@RequestParam(required = false) String transactionStatus,
			@RequestParam(required = false) LocalDate fromDate,
			@RequestParam(required = false) LocalDate toDate,
			@RequestParam(defaultValue = "0") int page ,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "sortBy") String SortBy,
			@RequestParam(defaultValue = "ASC") String sortDirection) { 
		
		ChequeDepositSearchResponse response = chequeDepositService.searchChequeDeposit(chequeDepositId,
				chequeNumber, 
				customerId, 
				accountId, 
				issuingBank, 
				ifscCode,
				chequeStatus,
				transactionStatus, 
				fromDate, 
				toDate, 
				page, 
				size, 
				SortBy, 
				sortDirection);
		
		return ResponseEntity.ok(response);
		
	}	

}
