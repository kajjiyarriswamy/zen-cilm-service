package com.zenbank.ams.account_management_service.entity;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="order_table")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="order_id")
	private Long orderId;
	
	@Column(name="order_description")
	private String orderDescription;
	
	@Column(name="item")
	private String item;
	
	@Column(name="order_qty")
	private Integer orderQty;
	
	@Column(name="order_cost")
	private BigDecimal orderCost;
	
	@Column(name="order_unit_cost")
	private BigDecimal orderUnitCost;
	
	@Column(name="created_date")
	private LocalDate createdDate;
	

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

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

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	
	
	
	
	

}
