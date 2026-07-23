package com.zenbank.ams.account_management_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.ams.account_management_service.dto.OrderDto;
import com.zenbank.ams.account_management_service.service.TestService;

@RestController
@RequestMapping("/api/order")
public class TestController {
	
	@Autowired
	@Qualifier("TestService")
	private TestService testService;
	
	@PostMapping("/create")
	public ResponseEntity<?> order(@RequestBody OrderDto dto){
		
		Long orderId=testService.createOrder(dto);
		return new ResponseEntity("SucessFully created order"+orderId,HttpStatus.CREATED);
	}
	

}
