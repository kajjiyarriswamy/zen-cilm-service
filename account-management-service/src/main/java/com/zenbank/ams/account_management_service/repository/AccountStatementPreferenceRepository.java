package com.zenbank.ams.account_management_service.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.entity.AccountStatementPreference;

@Repository
public interface AccountStatementPreferenceRepository extends JpaRepository<AccountStatementPreference, Long> {

	boolean existsByAccountAndDeliveryStatus(Account account, String string);

	Optional<AccountStatementPreference> findByAccountAndDeliveryStatus(Account account, String deliveryStatus);

	@Query("""
			SELECT s
			FROM AccountStatementPreference s
			WHERE (:accountId IS NULL OR s.account.accountId = :accountId)
			  AND (:statementType IS NULL OR s.statementType = :statementType)
			  AND (:statementFrequency IS NULL OR s.statementFrequency = :statementFrequency)
			  AND (:deliveryStatus IS NULL OR s.deliveryStatus = :deliveryStatus)
			""")
	Page<AccountStatementPreference> searchAccountStatement(@Param("accountId") Long accountId,
			@Param("statementType") String statementType, @Param("statementFrequency") String statementFrequency,
			@Param("deliveryStatus") String deliveryStatus, Pageable pageable);

}
