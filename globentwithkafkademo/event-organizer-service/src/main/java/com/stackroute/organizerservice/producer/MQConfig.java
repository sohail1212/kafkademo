//package com.stackroute.organizerservice.producer;
//
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class MQConfig {
//    public static final String QUEUE1 = "message_queue";
//    public static final String EXCHANGE1 = "message_exchange";
//    public static final String ROUTING_KEY1 = "message_routingKey";
//
//    @Bean
//    public Queue queue1() {
//        return  new Queue(QUEUE1);
//    }
//
//    @Bean
//    public TopicExchange exchange1() {
//        return new TopicExchange(EXCHANGE1);
//    }
//
//    @Bean
//    public Binding binding1(Queue queue, TopicExchange exchange) {
//        return BindingBuilder
//                .bind(queue)
//                .to(exchange)
//                .with(ROUTING_KEY1);
//    }
//
//    @Bean
//    public MessageConverter messageConverter1() {
//        return  new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    public AmqpTemplate template1(ConnectionFactory connectionFactory) {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory);
//        template.setMessageConverter(messageConverter1());
//        return  template;
//    }
//}
