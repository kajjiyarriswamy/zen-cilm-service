package com.zenbank.deposit_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenbank.deposit_service.entity.DepositStatusHistory;

@Repository
public interface DepositStatusHistoryRepository extends 
JpaRepository<DepositStatusHistory, Long> {

}
