package com.zenbank.cilm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.cilm.dto.CustomerPreferenceRequestDto;
import com.zenbank.cilm.dto.CustomerPreferenceResponseDto;
import com.zenbank.cilm.service.CustomerPreferenceService;
import com.zenbank.cilm.utility.ApiResponseUtil;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer-preferences")
public class CustomerPreferenceController {
	
	private final CustomerPreferenceService preferenceService;
	
	public CustomerPreferenceController(CustomerPreferenceService preferenceService) {
		this.preferenceService= preferenceService;
	}
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> createPreference(
			@Valid @RequestBody CustomerPreferenceRequestDto dto) {
		
		CustomerPreferenceResponseDto responce = preferenceService.
				createPreference(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(
				ApiResponseUtil.success(responce));
	}
	@GetMapping
	public ResponseEntity<Map<String, Object>> getAllPreference() {
		
		List<CustomerPreferenceResponseDto> list = preferenceService.getAllPreferences();
		
		return ResponseEntity.ok(ApiResponseUtil.success(list));
	}
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> getPreferenceById(@PathVariable Long id) {
		
		return preferenceService.getPreferenceById(id)
				.map(preference -> ResponseEntity.ok(ApiResponseUtil.success(preference)))
	            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
	                    .body(ApiResponseUtil.error("Customer Preference not found")));
	}

}
