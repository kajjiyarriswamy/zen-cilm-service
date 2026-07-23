package com.zenbank.ams.account_management_service.dto;

import java.math.BigDecimal;

public class OrderDto {

	private String orderDescription;

	private String item;

	private Integer orderQty;

	private BigDecimal orderCost;
	


	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(Integer orderQty) {
		this.orderQty = orderQty;
	}

	public BigDecimal getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(BigDecimal orderCost) {
		this.orderCost = orderCost;
	}

	public BigDecimal getOrderUnitCost() {
		return orderUnitCost;
	}

	public void setOrderUnitCost(BigDecimal orderUnitCost) {
		this.orderUnitCost = orderUnitCost;
	}

	private BigDecimal orderUnitCost;

}
