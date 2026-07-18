package com.zenbank.ams.account_management_service.repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.entity.AccountPassbookRequest;

public interface AccountPassbookRequestRepository extends JpaRepository<AccountPassbookRequest, Long> {

	boolean existsByAccountAccountIdAndRequestStatusIn(Long accountId, List<String> status);

	Optional<AccountPassbookRequest> findByPassbookRequestIdAndAccountAccountId(Long passbookRequestId, Long accountId,
	Account account);

	Optional<AccountPassbookRequest> findByPassbookRequestIdAndAccountAccountId(Long passbookRequestId, Long accountId);

	@Query("""
			SELECT p FROM AccountPassbookRequest p
			WHERE (:accountNumber IS NULL OR p.accountNumber = :accountNumber)
			AND (:customerId IS NULL OR p.customerId =:customerId)
			AND (:requestType IS NULL OR p.requestType =:requestType)
			AND (:requestStatus IS NULL OR p.requestStatus =:requestStatus)
			AND (:requestMode IS NULL OR p.requestMode =:requestMode)
			AND (:deliveryMode IS NULL OR p.deliveryMode =:deliveryMode)
			AND (:branchCode IS NULL OR p.branchCode =:branchCode)
			AND (:fromDate IS NULL OR  p.createdDate >=:fromDate)
			AND (:toDate IS NULL OR  p.createdDate <=:toDate)
			""")

	Page<AccountPassbookRequest> searchPassbookRequest(@Param("accountNumber") String accountNumber,
			@Param("customerId") String customerId, @Param("requestType") String requestType,
			@Param("requestStatus") String requestStatus, @Param("requestMode") String requestMode,
			@Param("deliveryMode") String deliveryMode, @Param("branchCode") String branchCode,
			@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate, Pageable pageable);

}
