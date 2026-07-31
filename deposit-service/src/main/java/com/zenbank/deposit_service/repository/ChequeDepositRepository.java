package com.zenbank.deposit_service.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.zenbank.deposit_service.entity.ChequeDeposit;

public interface ChequeDepositRepository extends JpaRepository<ChequeDeposit, Long> {

	
	 @Query("""
	  		   SELECT d
	  		   From ChequeDeposit d
	  		   WHERE (:chequeDepositId IS NULL OR d.chequeDepositId = :chequeDepositId)
	  		   And (:chequeNumber IS NULL OR d.chequeNumber = :chequeNumber)
	  		   And (:customerId IS NULL OR d.depositTransaction.customerId = :customerId)
	  		   AND (:account IS NULL OR d.depositTransaction.accountId = :account)
	  		   AND (:issuingBank IS NULL OR d.issuingBank = :issuingBank)
               AND (:ifscCode IS NULL OR d.ifscCode = :ifscCode)
               AND (:chequeStatus IS NULL OR d.chequeStatus = :chequeStatus)  		   
	  		   AND (:transactionStatus IS NULL OR d.depositTransaction.transactionStatus = :transactionStatus)
	  		   AND (:fromDate IS NULL OR d.depositTransaction.transactionDate >= :fromDate)
	  		   AND (:toDate IS NULL OR d.depositTransaction.transactionDate <= :toDate)
	  		""")
	 
	     public Page<ChequeDeposit> searchChequeDeposit(
	    		 
	    		@Param("chequeDepositId") Long chequeDepositId,
	    		@Param("chequeNumber") String  chequeNumber,
	    		@Param("customerId") Long customerId,
	    		@Param("account") Long account,
	    		@Param("issuingBank") String issuingBank,
	    		@Param("ifscCode") String  ifscCode,
	    		@Param("chequeStatus") String chequeStatus,
	    		@Param("transactionStatus") String transactionStatus,
	    		@Param("fromDate") LocalDate fromDate,
	    		@Param("toDate")LocalDate toDate,
	    		
	    		Pageable pageble);

}
