package com.zenbank.ams.account_management_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenbank.ams.account_management_service.entity.InterestConfiguration;

public interface InterestConfigurationRepository extends JpaRepository<InterestConfiguration, Long>{
	Optional<InterestConfiguration> findByAccountTypeAndStatus(
            String accountType,
            String status);
}
