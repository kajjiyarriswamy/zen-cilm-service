package com.zenbank.cilm.repository;

import com.zenbank.cilm.entity.CustomerContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerContactRepository extends JpaRepository<CustomerContact, Long> {

    boolean existsByMobileNumber(String mobileNumber);

    boolean existsByEmail(String email);
}