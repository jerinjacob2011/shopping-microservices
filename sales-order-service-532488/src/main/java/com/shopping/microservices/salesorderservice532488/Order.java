package com.shopping.microservices.salesorderservice532488;

import java.util.Map;

public class Order {
	
	private String orderDesc;
	private String orderDate;
	private Long custId;
	private Map<String,Integer> itemNames;
	
	public String getOrderDesc() {
		return orderDesc;
	}
	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public Map<String, Integer> getItemNames() {
		return itemNames;
	}
	public void setItemNames(Map<String, Integer> itemNames) {
		this.itemNames = itemNames;
	}
	public Order(String orderDesc, String orderDate, Long custId, Map<String, Integer> itemNames) {
		super();
		this.orderDesc = orderDesc;
		this.orderDate = orderDate;
		this.custId = custId;
		this.itemNames = itemNames;
	}
	public Order() {}

}
