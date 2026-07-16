package com.zenbank.ams.account_management_service.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.zenbank.ams.account_management_service.dto.CreateStatementPreferenceRequest;
import com.zenbank.ams.account_management_service.dto.StatementPreferenceData;
import com.zenbank.ams.account_management_service.dto.StatementPreferenceResponse;
import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.entity.AccountStatementPreference;
import com.zenbank.ams.account_management_service.exception.ResourceNotFoundException;
import com.zenbank.ams.account_management_service.exception.StatementPreferenceException;
import com.zenbank.ams.account_management_service.repository.AccountRepository;
import com.zenbank.ams.account_management_service.repository.AccountStatementPreferenceRepository;

import jakarta.validation.Valid;

@Service
public class StatementPreferenceService implements StatementPreferenceServiceImp {

	private final AccountRepository accountRepository;
	private final AccountStatementPreferenceRepository statementPreferenceRepository;

	public StatementPreferenceService(AccountRepository accountRepository,
			AccountStatementPreferenceRepository statementPreferenceRepository) {

		this.accountRepository = accountRepository;
		this.statementPreferenceRepository = statementPreferenceRepository;
	}

	@Override
	public StatementPreferenceResponse createStatementPreference(Long accountId,
			@Valid CreateStatementPreferenceRequest requestDto) {

		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new StatementPreferenceException("ACC_001", "Account not found"));

		if (!"ACTIVE".equalsIgnoreCase(account.getAccountStatus())) {
			throw new StatementPreferenceException("ACC_002", "Account is not active");
		}

		if (statementPreferenceRepository.existsByAccountAndDeliveryStatus(account, "ACTIVE")) {

			throw new StatementPreferenceException("STM_001", "Statement preference already exists.");
		}

		AccountStatementPreference preference = new AccountStatementPreference();

		preference.setAccount(account);
		preference.setStatementType(requestDto.getStatementType());
		preference.setStatementFrequency(requestDto.getStatementFrequency());
		preference.setEmailId(requestDto.getEmailId());
		preference.setPasswordProtected(requestDto.getPasswordProtected());

		preference.setDeliveryStatus("ACTIVE");
		preference.setCreatedBy("EMP001");
		preference.setCreatedDate(LocalDateTime.now());
		preference.setUpdatedBy("EMP001");
		preference.setUpdatedDate(LocalDateTime.now());
		preference.setLastGeneratedDate(LocalDate.now());

		preference = statementPreferenceRepository.save(preference);

		StatementPreferenceResponse response = new StatementPreferenceResponse();
		response.setStatus("SUCCESS");
		response.setMessage("Statement preference created successfully.");
		response.setPreferenceId("SP=  " + preference.getPreferenceId());

		return response;

	}

	@Override
	public StatementPreferenceResponse getStatementPreference(Long accountId) {

		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account not found"));

		AccountStatementPreference preference = statementPreferenceRepository
				.findByAccountAndDeliveryStatus(account, "ACTIVE")
				.orElseThrow(() -> new ResourceNotFoundException("Statement preference not found."));

		StatementPreferenceData data = new StatementPreferenceData();

		data.setPreferenceId("SP " + preference.getPreferenceId());
		data.setStatementType(preference.getStatementType());
		data.setStatementFrequency(preference.getStatementFrequency());
		data.setEmailId(preference.getEmailId());
		data.setPasswordProtected(preference.getPasswordProtected());
		data.setDeliveryStatus(preference.getDeliveryStatus());

		StatementPreferenceResponse response = new StatementPreferenceResponse();

		response.setStatus("SUCCESS");
		response.setData(data);

		return response;
	}

	@Override
	public StatementPreferenceResponse updateStatement(Long accountId, CreateStatementPreferenceRequest dto) {

		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account Not Found"));

		AccountStatementPreference pr = statementPreferenceRepository.findByAccountAndDeliveryStatus(account, "ACTIVE")
				.orElseThrow(() -> new ResourceNotFoundException("Statement preference not found"));

		pr.setStatementType(dto.getStatementType());
		pr.setStatementFrequency(dto.getStatementFrequency());
		pr.setEmailId(dto.getEmailId());
		pr.setPasswordProtected(dto.getPasswordProtected());
		pr.setDeliveryStatus(dto.getDeliveryStatus());

		pr.setUpdatedBy("EMP001");
		pr.setUpdatedDate(LocalDateTime.now());

		statementPreferenceRepository.save(pr);

		StatementPreferenceResponse response = new StatementPreferenceResponse();

		response.setStatus("SUCCESS");
		response.setMessage("Statement preference updated successfully");

		return response;

	}

}
