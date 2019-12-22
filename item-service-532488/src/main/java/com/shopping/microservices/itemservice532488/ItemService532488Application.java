package com.shopping.microservices.itemservice532488;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ItemService532488Application {

	public static void main(String[] args) {
		SpringApplication.run(ItemService532488Application.class, args);
	}

}
