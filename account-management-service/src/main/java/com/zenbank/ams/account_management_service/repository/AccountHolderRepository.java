package com.zenbank.ams.account_management_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenbank.ams.account_management_service.entity.JointAccountHolder;

@Repository
public interface AccountHolderRepository extends JpaRepository<JointAccountHolder, Long>{

}
