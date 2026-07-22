package com.zenbank.ams.account_management_service.repository;

import com.zenbank.ams.account_management_service.entity.AccountChequeBookRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AccountCheckBookRequestRepository extends JpaRepository<AccountChequeBookRequest, Long> {

    boolean existsByAccountIdAndRequestStatusIn(Long accountId, Collection<String> requestStatuses);

}
