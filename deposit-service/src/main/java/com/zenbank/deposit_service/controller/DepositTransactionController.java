package com.zenbank.deposit_service.controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.deposit_service.dto.DepositResponse;
import com.zenbank.deposit_service.service.DepositTransactionService;
import com.zenbank.deposit_service.utility.DepositTransactionUtil;

@RestController
@RequestMapping("api/v1/deposits")
public class DepositTransactionController {
	
	@Autowired
	private DepositTransactionService searchService;
	
	@GetMapping("/{depositId}")
//	public ResponseEntity<DepositResponse> getDepositTransaction(@PathVariable Long depositId){
//		DepositResponse response=service.getDepositTransactionDetails(depositId);
//		return ResponseEntity.ok(response);
		public ResponseEntity<Map<String,Object>> searchDepositTransactionByParams(@RequestParam(required=false) Long customerId ,@RequestParam(required=false)  Long accountId,
				@RequestParam(required=false) String transactionReference ,@RequestParam(required=false) String depositType ,@RequestParam(required=false) String depositChannel ,
				@RequestParam(required=false) String transactionStatus ,@RequestParam(required=false) LocalDate fromDate ,@RequestParam(required=false) LocalDate toDate  ,
				@RequestParam(required=false)  String branchCode,@RequestParam(defaultValue = "0") Integer page ,@RequestParam(defaultValue="10") Integer size ,
				@RequestParam(defaultValue = "transactionDate") String sortBy , @RequestParam(defaultValue = "DESC") String sortDirection  ) {
			
			
		        
			
			DepositResponse dsr	 = searchService.searchByparams(customerId,accountId,transactionReference,depositType,depositChannel,transactionStatus,
					fromDate,toDate,branchCode,page,size,sortBy,sortDirection);
			
			  return ResponseEntity.status(HttpStatus.CREATED).body(DepositTransactionUtil.created(dsr));
	}

}
