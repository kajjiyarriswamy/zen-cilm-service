package com.zenbank.ams.account_management_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenbank.ams.account_management_service.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
