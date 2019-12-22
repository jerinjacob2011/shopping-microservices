package com.shopping.microservices.customerservice532488;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@EnableHystrix
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	MessageSenderService messageSenderService;
	
	@Autowired
	CustomerConfiguration customerConfiguration;
	
	@GetMapping("service1/customers")
	public List<Customer> getAll(){
		return customerRepository.findAll();
	}
	
	@GetMapping("service1/customer/{customerId}")
	@HystrixCommand(fallbackMethod="fallBackmethodCustomer")
	public Customer getCustomer(@PathVariable Long customerId){
		Customer customer=customerRepository.findOne(customerId);
		if(customer!=null) {
			return customer;
		}else {
			throw new RuntimeException("Did not find customer with id:"+customerId);
		}
	}
	
	@GetMapping("service1/customer/id/{customerId}/email/{email}/firstName/{firstName}/lastName/{lastName}")
	public Customer createCustomer(@PathVariable Long customerId,@PathVariable String email,@PathVariable String firstName,@PathVariable String lastName){
		Customer customer= new Customer(customerId,email,firstName,lastName);
		customerRepository.saveAndFlush(customer);
		messageSenderService.sendMessage(customerId);
		return customer;
	}
	
	public Customer fallBackmethodCustomer(@PathVariable Long customerId){
		return new Customer(1000l,"guest@shopping.com",customerConfiguration.getDefaultFirstName(),customerConfiguration.getDefaultLastName());
	}
}
