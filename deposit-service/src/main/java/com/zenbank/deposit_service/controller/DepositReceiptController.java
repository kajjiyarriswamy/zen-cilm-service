package com.zenbank.deposit_service.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.deposit_service.dto.DepositReceiptResponseDto;
import com.zenbank.deposit_service.service.IDepositReceiptService;
import com.zenbank.deposit_service.utility.ApiResponseUtil;

@RestController
@RequestMapping("/api/v1/deposits")
public class DepositReceiptController {
	
	@Autowired
	private IDepositReceiptService depositreceiptservice;
	
	@PostMapping("/{depositId}/receipt")
	public ResponseEntity<Map<String,Object>> createReceipt(
			@PathVariable Long depositId){
		DepositReceiptResponseDto response=depositreceiptservice.createDepositReceipt(depositId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseUtil.created(response));
		
	}
	
    @GetMapping("/{depositId}/receipt")
    public ResponseEntity<DepositReceiptResponseDto> getDepositReceipt(
            @PathVariable Long depositId) {

        DepositReceiptResponseDto response = depositreceiptservice.getDepositReceipt(depositId);

        return ResponseEntity.ok(response);

    }
}
