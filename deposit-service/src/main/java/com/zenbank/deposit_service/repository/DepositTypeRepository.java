package com.zenbank.deposit_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenbank.deposit_service.entity.DepositType;

public interface DepositTypeRepository extends JpaRepository<DepositType, Long> {

}
