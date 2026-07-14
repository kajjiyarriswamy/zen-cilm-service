package com.zenbank.ams.account_management_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.entity.AccountStatementPreference;

@Repository
public interface AccountStatementPreferenceRepository extends JpaRepository<AccountStatementPreference, Long> {

	boolean existsByAccountAndDeliveryStatus(Account account, String string);

}
