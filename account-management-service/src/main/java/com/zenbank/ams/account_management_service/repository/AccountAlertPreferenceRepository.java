package com.zenbank.ams.account_management_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenbank.ams.account_management_service.entity.AccountAlertPreference;

public interface AccountAlertPreferenceRepository extends JpaRepository<AccountAlertPreference, Integer> {
	

    Optional<AccountAlertPreference> findByAccount_AccountId(Long accountId);

    boolean existsByAccount_AccountId(Long accountId);
	

}
