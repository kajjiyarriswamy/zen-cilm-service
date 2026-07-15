package com.zenbank.ams.account_management_service.repository;

import com.zenbank.ams.account_management_service.entity.AccountChequeBookRequest;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface AccountCheckBookRequestRepository extends JpaRepository<AccountChequeBookRequest, Long> {

}
