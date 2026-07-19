package com.zenbank.ams.account_management_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.entity.AccountDebitCard;

@Repository
public interface DebitCardRepository extends JpaRepository<AccountDebitCard, Long> {
	
	
	 
	 boolean existsByAccount_AccountIdAndCardStatusIn(
	            Long accountId,
	            List<String> cardStatus);

}
