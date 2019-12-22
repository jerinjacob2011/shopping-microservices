package com.shopping.microservices.salesorderservice532488;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="zuul-edge-server")
@RibbonClient("customer-service-532488")
public interface CustomerService {

	@GetMapping("customer-service-532488/service1/customer/{customerId}")
	public CustomerSos getCustomer(@PathVariable("customerId") Long customerId);
}
