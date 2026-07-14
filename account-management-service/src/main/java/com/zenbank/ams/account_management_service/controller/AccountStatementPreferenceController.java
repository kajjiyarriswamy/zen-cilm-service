package com.zenbank.ams.account_management_service.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zenbank.ams.account_management_service.dto.CreateStatementPreferenceRequest;
import com.zenbank.ams.account_management_service.dto.StatementPreferenceResponse;

import com.zenbank.ams.account_management_service.service.StatementPreferenceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountStatementPreferenceController {

	private final StatementPreferenceService statementPreferenceService;

	public AccountStatementPreferenceController(StatementPreferenceService statementPreferenceService) {
		this.statementPreferenceService = statementPreferenceService;
	}

	@PostMapping("/{accountId}/statement-preferences")
	public ResponseEntity<StatementPreferenceResponse> createStatementPreference(@PathVariable Long accountId,
			@Valid @RequestBody CreateStatementPreferenceRequest requestDto) {

		StatementPreferenceResponse response = statementPreferenceService.createStatementPreference(accountId,
				requestDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/{accountId}/statement-preferences")
	public ResponseEntity<StatementPreferenceResponse> getStatementPreference(
			@PathVariable Long accountId) {
		StatementPreferenceResponse response = statementPreferenceService.getStatementPreference(accountId);

		return ResponseEntity.ok(response);

	}
}