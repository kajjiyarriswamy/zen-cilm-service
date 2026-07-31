package com.zenbank.deposit_service.controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.deposit_service.dto.DepositSearchResponse;
import com.zenbank.deposit_service.service.DepositTransactionService;
import com.zenbank.deposit_service.utility.DepositTransactionUtil;


@RestController
@RequestMapping("api/v1")
public class DepositTransactionController {
	
	@Autowired
	private DepositTransactionService depositTransactionService;
	
	
	
		@GetMapping("/deposits")
		public ResponseEntity<Map<String,Object>> searchDepositTransactionByParams(
				
				@RequestParam(required=false) Long depositId,
				@RequestParam(required=false) String transactionReference,
				@RequestParam(required=false) Long customerId,
				@RequestParam(required=false)  Long accountId,				
				@RequestParam(required=false) String depositType,
				@RequestParam(required=false) String depositChannel,
				@RequestParam(required=false) Double amount,
				@RequestParam(required=false) String transactionStatus,
				@RequestParam(required=false) LocalDate fromDate,
				@RequestParam(required=false) LocalDate toDate ,
				@RequestParam(required=false)  String branchCode,
				@RequestParam(defaultValue = "0") Integer page,
				@RequestParam(defaultValue="10") Integer size,
				@RequestParam(defaultValue = "transactionDate") String sortBy,
				@RequestParam(defaultValue = "ASC") String sortDirection) {
					
			DepositSearchResponse dsr = depositTransactionService.searchByparams(depositId,
					transactionReference,
					customerId,
					accountId,
					depositType,
					depositChannel,
				    amount,
					transactionStatus,
					fromDate,
					toDate,
					branchCode,
					page,
					size,
					sortBy,
					sortDirection);
			
			return ResponseEntity.ok(DepositTransactionUtil.created(dsr));
			  //return ResponseEntity.status(HttpStatus.CREATED).body(DepositTransactionUtil.created(dsr));
	}

}
