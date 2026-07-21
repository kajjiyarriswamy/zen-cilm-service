package com.zenbank.ams.account_management_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import com.zenbank.ams.account_management_service.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
	public List<Account> findBycustomerIdEquals(String custId);
	
	
	 @Query("""
		        SELECT a
		        FROM Account a
		        WHERE (:customerId IS NULL OR a.customerId = :customerId)
		          AND (:accountNumber IS NULL OR a.accountNumber = :accountNumber)
		          AND (:mobileNumber IS NULL OR 1 = 1)
                  AND (:panNumber IS NULL OR 1 = 1)
		          AND (:status IS NULL OR a.accountStatus = :status)
		          AND (:branchCode IS NULL OR a.branchCode = :branchCode)
		    """)
	public List<Account>  findByCustomersByParams(@Param("customerId") String customerId,
            @Param("accountNumber") Long accountNumber,
            @Param("mobileNumber") Long mobileNumber,
            @Param("panNumber") String panNumber,
            @Param("status") String status,
            @Param("branchCode") String branchCode,
            Pageable pageable);

	 
	 
	 
	 
	 
}
