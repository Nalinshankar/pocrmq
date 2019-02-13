package com.javasampleapproach.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
    public class RabbitMqConfig {

        public static final String ROUTING_KEY = "my.queue.key";

        @Bean
        Queue queue() {
            return new Queue(ROUTING_KEY, true);
        }

        @Bean
        TopicExchange exchange() {
            return new TopicExchange("my_queue_exchange");
        }

        @Bean
        Binding binding(Queue queue, TopicExchange exchange) {
            return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
        }
        @Bean
        public MessageConverter jsonMessageConverter(){
            return new Jackson2JsonMessageConverter();
        }

        public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
            final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
            rabbitTemplate.setMessageConverter(jsonMessageConverter());
            return rabbitTemplate;
        }

    }
