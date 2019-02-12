package com.javasampleapproach.rabbitmq.producer;

import com.javasampleapproach.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Producer {

	@Autowired
	private AmqpTemplate rabbitTemplate;


	public void sendMessage(String message) {

		//System.out.println(new Date());
		rabbitTemplate.convertAndSend(RabbitMqConfig.ROUTING_KEY, message);
		//System.out.println("Is listener returned ::: "+rabbitTemplate.isReturnListener());

	}
}

