package com.zenbank.ams.account_management_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenbank.ams.account_management_service.entity.AccountClosure;

@Repository
public interface AccountClosureRepository extends JpaRepository<AccountClosure, Long> {
	Optional<AccountClosure> findByAccountAccountId(Long accountId);
}
