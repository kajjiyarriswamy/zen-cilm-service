package com.zenbank.ams.account_management_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenbank.ams.account_management_service.entity.AccountLimit;


@Repository
public interface AccountLimitRepository extends JpaRepository<AccountLimit, Long>{
	
	 Optional<AccountLimit> findByAccountAccountId(Long accountId);

}
