package com.zenbank.ams.account_management_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenbank.ams.account_management_service.entity.AccountPassbookRequest;

public interface AccountPassbookRequestRepository extends JpaRepository<AccountPassbookRequest, Long> {

	boolean existsByAccountAccountIdAndRequestStatusIn(Long accountId, List<String> status);

}
