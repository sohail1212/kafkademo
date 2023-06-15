package com.stackroute.organizerservice.producer;

import com.stackroute.organizerservice.dto.EventDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;


@Configuration
public class KafkaProducer {

    private String topicName = "topic1";


    @Autowired
    private KafkaTemplate<String, EventDetails> kafkaTemplate;


    public void sendMessage(EventDetails event){
        Message<EventDetails> message= MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC,topicName)
                .build();
        kafkaTemplate.send(message);

    }
}
