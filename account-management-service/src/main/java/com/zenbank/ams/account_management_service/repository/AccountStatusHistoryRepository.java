
package com.zenbank.ams.account_management_service.repository;

import com.zenbank.ams.account_management_service.entity.AccountStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountStatusHistoryRepository extends JpaRepository<AccountStatusHistory, Long> {

    List<AccountStatusHistory> findByAccount_AccountIdOrderByPerformedAtDesc(Long accountId);

}