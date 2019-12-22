package com.shopping.microservices.salesorderservice532488;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients("com.shopping.microservices.salesorderservice532488")
public class SalesOrderController {

	@Autowired
	CustomerSosRepository customerSosRepository;
	
	@Autowired
	OrderLineItemRepository orderLineItemRepository;
	
	@Autowired
	SalesOrderRepository salesOrderRepository;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	CustomerService customerService;
	
	static final Logger logger = LoggerFactory.getLogger(SalesOrderController.class);
	
	public static final String DEFAULT_PARSING_QUEUE = "online_shopping_q";
	
	@RabbitListener(queues = DEFAULT_PARSING_QUEUE)
	public void consumeDefaultMessage(final CustomerMessage message) {
		logger.info("Message Recieved in Orders service {}", message.toString());
		Long customerId=message.getCustomerId();
		CustomerSos customer= customerService.getCustomer(customerId);
		customerSosRepository.saveAndFlush(customer);
	}
	
	@PostMapping("service3/orders")
	public Long createOrder(@RequestBody Order order) {
		OrderLineItem lineItem = new OrderLineItem();
		SalesOrder salesOrder = new SalesOrder();
		CustomerSos customer = customerSosRepository.findOne(order.getCustId());
		salesOrder.setCustId(customer.getCustomerId());
		salesOrder.setOrderDate(order.getOrderDate());
		salesOrder.setOrderDescription(order.getOrderDesc());
		Float totalPrice=(float) 0.0;
		Map<String,Integer> itemNames=order.getItemNames();
		Set<String> items=itemNames.keySet();
		for(String itemName: items) {
			lineItem= itemService.getItemByName(itemName);
			totalPrice+=lineItem.getItemPrice()*itemNames.get(itemName);
		}
		salesOrder.setTotalPrice(totalPrice);
		salesOrderRepository.saveAndFlush(salesOrder);
		
		for(String itemName: items) {
			lineItem = new OrderLineItem();
			lineItem= itemService.getItemByName(itemName);
			lineItem.setItemQuantity(itemNames.get(itemName));
			lineItem.setOrderId(salesOrder.getSalesOrderId());
			orderLineItemRepository.saveAndFlush(lineItem);
		}
		return salesOrder.getSalesOrderId();
	}
	
	@GetMapping("service3/customers")
	public List<CustomerSos> getAllCustomers(){
		return customerSosRepository.findAll();
	}
	
	@GetMapping("service3/lineItems")
	public List<OrderLineItem> getAllLineItems(){
		return orderLineItemRepository.findAll();
	}
	
	@GetMapping("service3/orders")
	public List<SalesOrder> getAllOrders(){
		return salesOrderRepository.findAll();
	}
}
