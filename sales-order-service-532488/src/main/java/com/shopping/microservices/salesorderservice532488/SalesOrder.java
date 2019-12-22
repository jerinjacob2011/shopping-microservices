package com.shopping.microservices.salesorderservice532488;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SalesOrder {

	@Id
	@Column(name="sales_order_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long salesOrderId;
	
	@Column(name="order_date")
	private String orderDate;
	
	@Column(name="cust_id")
	private Long custId;
	
	@Column(name="order_desc")
	private String orderDescription;
	
	@Column(name="total_price")
	private Float totalPrice;

	public SalesOrder() {}
	
	public SalesOrder(Long salesOrderId, String orderDate, Long custId, String orderDescription, Float totalPrice) {
		super();
		this.salesOrderId = salesOrderId;
		this.orderDate = orderDate;
		this.custId = custId;
		this.orderDescription = orderDescription;
		this.totalPrice = totalPrice;
	}
	public Long getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(Long salesOrderId) {
		this.salesOrderId = salesOrderId;
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

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

}

