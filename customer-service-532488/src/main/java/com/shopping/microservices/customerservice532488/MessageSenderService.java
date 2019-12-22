package com.shopping.microservices.customerservice532488;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderService {
	
	private static final Logger log= LoggerFactory.getLogger(MessageSenderService.class);
	
	private final RabbitTemplate rabbitTemplate;
	
	public MessageSenderService(final RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate=rabbitTemplate;
	}
	
	public void sendMessage(Long custId) {
		CustomerMessage customerMessage =new CustomerMessage(custId);
		rabbitTemplate.convertAndSend(EventProducerConfiguration.EXCHANGE_NAME,EventProducerConfiguration.ROUTING_KEY,customerMessage);
		log.info("customer-service-532488 message sent"+custId.toString());
	}

}
