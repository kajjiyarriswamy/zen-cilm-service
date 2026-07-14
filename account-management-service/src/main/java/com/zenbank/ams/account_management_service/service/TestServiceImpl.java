package com.zenbank.ams.account_management_service.service;

import java.security.Timestamp;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.zenbank.ams.account_management_service.dto.OrderDto;
import com.zenbank.ams.account_management_service.entity.Order;
import com.zenbank.ams.account_management_service.repository.OrderRepository;

@Primary
@Service("TestService") 
public class TestServiceImpl implements TestService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Long createOrder(OrderDto dto) {
		
		Order order =new Order();
		order.setItem(dto.getItem());
		order .setOrderCost(dto.getOrderCost());
		order.setOrderDescription(dto.getOrderDescription());
		order.setOrderQty(dto.getOrderQty());
		order.setOrderUnitCost(dto.getOrderUnitCost());
		order.setCreatedDate(LocalDate.now());
		Order dbOrder=orderRepository.save(order);
		return dbOrder.getOrderId();
	}
	

}
