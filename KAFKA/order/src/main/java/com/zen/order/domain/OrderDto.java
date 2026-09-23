package com.zen.order.domain;

public class OrderDto {
	
	private String orderId;
	private String description;
	private String productCode;
    private String productName;
    private String status;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public OrderDto(String orderId, String description, String productCode, String productName, String status) {
		super();
		this.orderId = orderId;
		this.description = description;
		this.productCode = productCode;
		this.productName = productName;
		this.status = status;
	}
	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
