package com.zenbank.ams.account_management_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenbank.ams.account_management_service.entity.AccountNominee;
@Repository
public interface AccountNomineeRepo extends JpaRepository<AccountNominee, Long>  {
	List<AccountNominee> findByAccountIdAccountId(Long accountId);
}
