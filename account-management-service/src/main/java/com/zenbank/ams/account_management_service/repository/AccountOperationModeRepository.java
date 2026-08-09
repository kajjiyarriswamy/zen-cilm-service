package com.zenbank.ams.account_management_service.repository;

import com.zenbank.ams.account_management_service.entity.AccountOperation;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountOperationModeRepository extends JpaRepository<AccountOperation, Long> {


    Optional<AccountOperation> findById(@NonNull Long accountId);
}
