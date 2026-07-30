package com.zenbank.deposit_service.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
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
	  		   From DepositTransaction d
	  		   WHERE (:depositId IS NULL OR d.depositId = :depositId)
	  		   And(:transactionReference IS NULL OR d.transactionReference = :transactionReference)
	  		   And(:customerId IS NULL OR d.customerId = :customerId)
	  		   AND(:accountId IS NULL OR d.accountId = :accountId)
	  		   AND (:depositType IS NULL OR d.depositType = :depositType)
               AND (:depositChannel IS NULL OR d.depositChannel = :depositChannel)
               AND (:amount IS NULL OR d.amount = :amount)  		   
	  		   AND (:transactionStatus IS NULL OR d.transactionStatus = :transactionStatus)
	  		   And (:branchCode IS NULL OR d.branchCode = :branchCode)
	  		   AND (:fromDate IS NULL OR d.transactionDate >= :fromDate)
	  		   AND (:toDate IS NULL OR d.transactionDate <= :toDate)
	  		""")
	 
	     public Page<DepositTransaction> searchDeposits(
	    		 
	    		@Param("depositId") Long depositId,
	    		@Param("transactionReference") String transactionReference,
	    		@Param("customerId") Long customerId,
	    		@Param("accountId") Long accountId,
	    		@Param("depositType") String depositType,
	    		@Param("depositChannel") String depositChannel,
	    		@Param("amount") Double amount,
	    		@Param("transactionStatus") String transactionStatus,
	    		@Param("fromDate") LocalDate formDate,
	    		@Param("toDate")LocalDate toDate,
	    		@Param("branchCode") String branchCode,
	    		
	    		Pageable pageble);
	 
   }
