package com.zenbank.deposit_service.repository;

import com.zenbank.deposit_service.entity.DepositType;
import com.zenbank.deposit_service.enums.DepositTypeCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepositTypeRepository extends JpaRepository<DepositType, Long> {
    Optional<DepositType> findByTypeCode(DepositTypeCode typeCode);
}
