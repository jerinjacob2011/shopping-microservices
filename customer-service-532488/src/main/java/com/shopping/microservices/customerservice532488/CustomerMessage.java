package com.shopping.microservices.customerservice532488;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerMessage implements Serializable{
	
	private final Long customerId;

	public CustomerMessage(@JsonProperty("customerId")final Long customerId) {
		super();
		this.customerId = customerId;
	}

	public Long getCustomerId() {
		return customerId;
	}

}
