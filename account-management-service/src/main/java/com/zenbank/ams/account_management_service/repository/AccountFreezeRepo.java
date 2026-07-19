package com.zenbank.ams.account_management_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenbank.ams.account_management_service.entity.AccountFreeze;

public interface AccountFreezeRepo extends JpaRepository<AccountFreeze, Long> {

}
