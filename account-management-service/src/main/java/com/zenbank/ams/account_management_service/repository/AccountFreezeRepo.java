package com.zenbank.ams.account_management_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenbank.ams.account_management_service.entity.AccountFreeze;

public interface AccountFreezeRepo extends JpaRepository<AccountFreeze, Long> {
	List<AccountFreeze> findByAccountIdAndStatus(Long accountId, String status);
}
