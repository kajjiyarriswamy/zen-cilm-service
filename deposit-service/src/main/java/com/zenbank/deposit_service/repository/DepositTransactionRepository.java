package com.zenbank.deposit_service.repository;

import java.time.LocalDate;

import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.zenbank.deposit_service.entity.DepositTransaction;

@Repository
public interface DepositTransactionRepository extends JpaRepository<DepositTransaction, Long> {

	 @Query("""
	  		   SELECT d
	  		   From depositTransaction d
	  		   WHERE (:customerId IS NULL OR d.customerId = :customerId)
	  		   AND(:accountId IS NULL OR d.accountId = :accountId)
	  		   And(:transactionReference IS NULL OR d.transactionReference = :transactionReference)
	  		   
	  		   AND (:transactionStatus IS NULL OR d.transaction = :transactionStatus)
	  		   And (:branchCode IS NULL OR d.branchCode = :branchCode)
	  		   AND (:fromDate Is NULL OR d.transactionDate >= :formDate)
	  		   AND (:toDate IS NULL OR d.transactionDate <= :toDate)
	  		""")
	     public Page<DepositTransaction> searchDeposits(
	    		@Param("customerId") Long customerId,
	    		@Param("accountId") Long accountId,
	    		@Param("transactionReference") String transactionRefence,
	    		@Param("transactionStatus") String transactionStatus,
	    		@Param("fromDate") LocalDate formDate,
	    		@Param("toDate")LocalDate toDate,
	    		@Param("branchCode") String branchCode,
	    		Pageable pageble);
}
