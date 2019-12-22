package com.shopping.microservices.salesorderservice532488;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SalesOrderService532488Application {

	public static void main(String[] args) {
		SpringApplication.run(SalesOrderService532488Application.class, args);
	}

}
