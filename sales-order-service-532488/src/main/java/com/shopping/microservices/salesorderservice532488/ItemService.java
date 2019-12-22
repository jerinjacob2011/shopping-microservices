package com.shopping.microservices.salesorderservice532488;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="zuul-edge-server")
@RibbonClient("item-service-532488")
public interface ItemService {
	
	@GetMapping("item-service-532488/service2/itemName/{itemName}")
	public OrderLineItem getItemByName(@PathVariable("itemName") String itemName) ;
}
