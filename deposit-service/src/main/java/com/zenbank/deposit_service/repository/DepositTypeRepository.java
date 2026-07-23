package com.zenbank.deposit_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenbank.deposit_service.enums.DepositStatus;

public interface DepositTypeRepository extends JpaRepository<DepositStatus, Long> {

}
