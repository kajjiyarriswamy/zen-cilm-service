package com.zenbank.deposit_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenbank.deposit_service.entity.DepositCharge;

public interface DepositChargeRepository extends JpaRepository<DepositCharge, Long>{

}
