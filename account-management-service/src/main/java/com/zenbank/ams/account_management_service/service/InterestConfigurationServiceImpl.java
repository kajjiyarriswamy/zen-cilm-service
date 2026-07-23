package com.zenbank.ams.account_management_service.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenbank.ams.account_management_service.dto.CreateInterestConfigurationRequest;
import com.zenbank.ams.account_management_service.dto.InterestConfigurationResponse;
import com.zenbank.ams.account_management_service.dto.UpdateInterestConfigurationRequest;
import com.zenbank.ams.account_management_service.dto.UpdateInterestConfigurationResponseDto;
import com.zenbank.ams.account_management_service.dto.ViewInterestConfigurationDataDto;
import com.zenbank.ams.account_management_service.dto.ViewInterestConfigurationResponseDto;
import com.zenbank.ams.account_management_service.entity.InterestConfiguration;
import com.zenbank.ams.account_management_service.repository.InterestConfigurationRepository;


@Service
public class InterestConfigurationServiceImpl implements InterestConfigurationService{
	
	@Autowired
	InterestConfigurationRepository interestConfigurationRepository;

	@Override
	public InterestConfigurationResponse createInterestConfiguration(CreateInterestConfigurationRequest request) {
		if(request.getInterestRate().compareTo(BigDecimal.ZERO)<=0) {
			throw new RuntimeException("Intreset Rate Must be Greater than 0.");
		}
		if(request.getEffectiveFrom().isAfter(request.getEffectiveTo())) {
			throw new RuntimeException("Effective From date must be before Effective To date.");
		}
		Optional<InterestConfiguration>existing=interestConfigurationRepository.findByAccountTypeAndStatus(request.getAccountType(),"ACTIVE");
		if(existing.isPresent()) {
			throw new RuntimeException("Only one active configuration is allowed for an account type.");
		}
		
		InterestConfiguration config=new InterestConfiguration();
		config.setAccountType(request.getAccountType());
		config.setCreatedBy("SYSTEM");
		config.setCreatedDate(LocalDateTime.now());
		config.setEffectiveFrom(request.getEffectiveFrom());
		config.setEffectiveTo(request.getEffectiveTo());
		config.setInterestRate(request.getInterestRate());
		config.setStatus("ACTIVE");
		
		InterestConfiguration saved=interestConfigurationRepository.save(config);
		
		InterestConfigurationResponse response=new InterestConfigurationResponse();
		response.setStatus("SUCCESS");
		response.setMessage("Interest configuration created successfully.");
		response.setInterestId("INT"+100000+saved.getInterestId());
		return response;
	}

	@Override
	public ViewInterestConfigurationResponseDto viewInterestConfiguration() {
		List<InterestConfiguration> configuration=interestConfigurationRepository.findAll();
		if(configuration.isEmpty()) {
			throw new RuntimeException("Interest configuration not found.");
		}
		List<ViewInterestConfigurationDataDto>data=new ArrayList<>();
		for(InterestConfiguration con:configuration) {
			ViewInterestConfigurationDataDto dto=new ViewInterestConfigurationDataDto();
			dto.setInterestId("INT"+100000+con.getInterestId());
			dto.setAccountType(con.getAccountType());
			dto.setInterestRate(con.getInterestRate());
			dto.setEffectiveFrom(con.getEffectiveFrom());
			dto.setEffectiveTo(con.getEffectiveTo());
			data.add(dto);
			
		}
		ViewInterestConfigurationResponseDto response=new ViewInterestConfigurationResponseDto();
		response.setStatus("Success");
		response.setData(data);
		return response;
	}
	
	@Override
	public UpdateInterestConfigurationResponseDto updateInterestConfiguration(Long interestId,UpdateInterestConfigurationRequest request) {
		InterestConfiguration config=interestConfigurationRepository.findById(interestId).orElseThrow(()->new RuntimeException("Interest configuration not found."));
		
		if(request.getInterestRate().compareTo(BigDecimal.ZERO)<=0) {
			throw new RuntimeException("Intreset Rate Must be Greater than 0.");
		}
		if(request.getEffectiveFrom().isAfter(request.getEffectiveTo())) {
			throw new RuntimeException("Effective From date must be before Effective To date.");
		}
		
		config.setInterestRate(request.getInterestRate());
		config.setEffectiveFrom(request.getEffectiveFrom());
		config.setEffectiveTo(request.getEffectiveTo());
		
		interestConfigurationRepository.save(config);
		
		UpdateInterestConfigurationResponseDto response = new UpdateInterestConfigurationResponseDto();
		response.setStatus("SUCCESS");
		response.setMessage("Interest configuration updated successfully.");
		
		return response;
		
	}
	
}
