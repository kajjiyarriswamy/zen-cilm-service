package com.zenbank.ams.account_management_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenbank.ams.account_management_service.entity.AccountDebitCard;

@Repository
public interface DebitCardRepository extends JpaRepository<AccountDebitCard, Long> {

    // Existing method
    boolean existsByAccount_AccountIdAndCardStatusIn(
            Long accountId,
            List<String> cardStatus);

    // Get debit card by accountId and debitCardId
    Optional<AccountDebitCard> findByAccountAccountIdAndDebitCardId(
            Long accountId,
            Long debitCardId);
    
    //Update debit card
    
    Optional<AccountDebitCard> findByAccount_AccountIdAndDebitCardId(
            Long accountId,
            
            Long debitCardId);
   

}