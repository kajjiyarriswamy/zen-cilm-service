package com.zenbank.ams.account_management_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenbank.ams.account_management_service.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
