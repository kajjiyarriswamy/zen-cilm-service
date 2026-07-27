package com.zenbank.deposit_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenbank.deposit_service.entity.DepositChannel;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositChannelRepository extends JpaRepository<DepositChannel, Long> {
	
	//Optional<DepositChannel> findByChannelCode(String channelCode);

}
