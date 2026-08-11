package com.zenbank.deposit_service.repository;

import com.zenbank.deposit_service.entity.DepositChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepositChannelRepository extends JpaRepository<DepositChannel, Long> {
    Optional<DepositChannel> findByChannelCode(String channelCode);
}
