package com.zenbank.ams.account_management_service.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.ams.account_management_service.dto.CreateStatementPreferenceRequest;
import com.zenbank.ams.account_management_service.dto.StatementPreferenceResponse;
import com.zenbank.ams.account_management_service.service.StatementPreferenceService;
import com.zenbank.ams.account_management_service.utility.ApiResponseUtility;

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
	public ResponseEntity<StatementPreferenceResponse> getStatementPreference(@PathVariable Long accountId) {
		StatementPreferenceResponse response = statementPreferenceService.getStatementPreference(accountId);

		return ResponseEntity.ok(response);

	}

	@PutMapping("/{accountId}/statement-preferences")
	public ResponseEntity<StatementPreferenceResponse> updateStatement(@PathVariable Long accountId,
			@Valid @RequestBody CreateStatementPreferenceRequest dto) {

		StatementPreferenceResponse response = statementPreferenceService.updateStatement(accountId, dto);

		return ResponseEntity.ok(response);
	}

	@GetMapping("/statement-preferences/search")
	public ResponseEntity<Map<String, Object>> search(@RequestParam(required = false) Long accountId,
			@RequestParam(required = false) String statementType,
			@RequestParam(required = false) String statementFrequency,
			@RequestParam(required = false) String deliveryStatus, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {

		return ResponseEntity.ok(ApiResponseUtility.success(statementPreferenceService.searchAccount(accountId,
				statementType, statementFrequency, deliveryStatus, page, size)));
	}

}