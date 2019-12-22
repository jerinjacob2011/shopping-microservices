package com.shopping.microservices.customerservice532488;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="customer-service-532488")
@Component
public class CustomerConfiguration {
	
	private String defaultFirstName;
	private String defaultLastName;
	public String getDefaultFirstName() {
		return defaultFirstName;
	}
	public void setDefaultFirstName(String defaultFirstName) {
		this.defaultFirstName = defaultFirstName;
	}
	public String getDefaultLastName() {
		return defaultLastName;
	}
	public void setDefaultLastName(String defaultLastName) {
		this.defaultLastName = defaultLastName;
	}
	

}
