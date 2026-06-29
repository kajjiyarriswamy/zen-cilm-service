package com.zenbank.cilm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenbank.cilm.entity.CustomerPreferenceEntity;

@Repository
public interface CustomerPreferenceRepository extends JpaRepository<CustomerPreferenceEntity, Long> {

}
