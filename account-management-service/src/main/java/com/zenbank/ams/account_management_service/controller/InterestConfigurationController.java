package com.zenbank.ams.account_management_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zenbank.ams.account_management_service.dto.CreateInterestConfigurationRequest;
import com.zenbank.ams.account_management_service.dto.InterestConfigurationResponse;
import com.zenbank.ams.account_management_service.dto.UpdateInterestConfigurationRequest;
import com.zenbank.ams.account_management_service.dto.UpdateInterestConfigurationResponseDto;
import com.zenbank.ams.account_management_service.dto.ViewInterestConfigurationResponseDto;
import com.zenbank.ams.account_management_service.service.InterestConfigurationService;

@RestController
@RequestMapping("/api/v1/interest-configurations")
public class InterestConfigurationController {
	
	@Autowired
	private InterestConfigurationService intresetConfigurationService;
	@PostMapping
	public ResponseEntity<InterestConfigurationResponse>create(@RequestBody CreateInterestConfigurationRequest request){
		return ResponseEntity.ok(intresetConfigurationService.createInterestConfiguration(request));
	}
	@GetMapping
	public ResponseEntity<ViewInterestConfigurationResponseDto>getInterestConfigurationResponse(){
		return ResponseEntity.ok(intresetConfigurationService.viewInterestConfiguration());
	}
	@PutMapping("/{interestId}")
	public ResponseEntity<UpdateInterestConfigurationResponseDto> updateInterestConfiguration(
	        @PathVariable Long interestId,
	        @RequestBody UpdateInterestConfigurationRequest request) {

	    return ResponseEntity.ok(
	            intresetConfigurationService.updateInterestConfiguration(interestId, request));
	}
}
