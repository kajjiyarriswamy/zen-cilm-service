package com.zenbank.ams.account_management_service.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.zenbank.ams.account_management_service.dto.CreateJointHolderRequest;
import com.zenbank.ams.account_management_service.dto.CreateStatementPreferenceRequest;
import com.zenbank.ams.account_management_service.dto.JointHolderResponse;
import com.zenbank.ams.account_management_service.dto.StatementPreferenceData;
import com.zenbank.ams.account_management_service.dto.StatementPreferenceResponse;
import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.entity.AccountStatementPreference;
import com.zenbank.ams.account_management_service.entity.JointAccountHolder;
import com.zenbank.ams.account_management_service.exception.ResourceNotFoundException;
import com.zenbank.ams.account_management_service.exception.StatementPreferenceException;
import com.zenbank.ams.account_management_service.repository.AccountHolderRepository;
import com.zenbank.ams.account_management_service.repository.AccountRepository;
import com.zenbank.ams.account_management_service.repository.AccountStatementPreferenceRepository;

import jakarta.validation.Valid;

@Service
public class StatementPreferenceService implements StatementPreferenceServiceImp {

	private final AccountRepository accountRepository;
	private final AccountStatementPreferenceRepository statementPreferenceRepository;
	private final AccountHolderRepository accountHolderRepository;

	public StatementPreferenceService(AccountRepository accountRepository,
			AccountStatementPreferenceRepository statementPreferenceRepository, AccountHolderRepository accountHolderRepository) {

		this.accountRepository = accountRepository;
		this.statementPreferenceRepository = statementPreferenceRepository;
		this.accountHolderRepository=accountHolderRepository;
	}

	@Override
	public StatementPreferenceResponse createStatementPreference(Long accountId,
			@Validated CreateStatementPreferenceRequest requestDto) {

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

	@Override
	public Map<String, Object> searchAccount(Long accountId, String statementType, 
			String statementFrequency,
			String deliveryStatus, int page, int size) {
		
		Pageable pageable=PageRequest.of(page, size);
		
		Page<AccountStatementPreference> accountPage=statementPreferenceRepository
				.searchAccountStatement(accountId, statementType, statementFrequency, deliveryStatus, 
						pageable);
		
		if(accountPage.isEmpty()) {
			throw new ResourceNotFoundException("No statement preferenes found");
			
		}
		
		List<StatementPreferenceData> datas=accountPage.getContent()
				.stream().map(entity -> {
					
				StatementPreferenceData dto= new StatementPreferenceData();
				
						dto.setAccountId(entity.getAccount().getAccountId());
						dto.setStatementType(entity.getStatementType());
						dto.setStatementFrequency(entity.getStatementFrequency());
						dto.setDeliveryStatus(entity.getDeliveryStatus());
						
						return dto;
				}).toList();
		
		Map<String, Object> response=new LinkedHashMap<>();
		
		
		response.put("page", accountPage.getNumber());
		response.put("size", accountPage.getSize());
		response.put("totalRecords", accountPage.getNumberOfElements());
		response.put("data", datas);
		
		
		
		return response;
	}
	
    @Override
	public JointHolderResponse createAccountHolder(Long accountId, 
			@Valid CreateJointHolderRequest request) {
		Account account=accountRepository.findById(accountId).orElseThrow(()
				-> new ResourceNotFoundException("Account Id Not available "));
		
		JointAccountHolder holder=new JointAccountHolder();
		
		holder.setAccount(account);
		holder.setHolderName(request.getHolderName());
		holder.setRelationship(request.getRelationship());
		holder.setOperationMode(request.getOperationMode());
		holder.setCustomerId(request.getCustomerId());
		holder.setStatus("ACTIVE");
		holder.setCreateDate(LocalDateTime.now());
		holder.setCreatedBy("SYSTEM");
		
		holder.setUpdatedDate(LocalDateTime.now());
		holder.setUpdatedBy("SYSTEM");
		
		accountHolderRepository.save(holder);
		
		JointHolderResponse response=new JointHolderResponse();
		
		response.setStatus("SUCCESS");
		response.setMessage("Joint account holder added successfully");
		response.setHolderId("JoinHolder " + holder.getHolderId());
		
				
				
		return response;
	}

}
