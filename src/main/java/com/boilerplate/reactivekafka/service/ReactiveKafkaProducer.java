package com.boilerplate.reactivekafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class ReactiveKafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(ReactiveKafkaProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public ReactiveKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public Mono<Void> sendMessage(String topic, String message) {
        return Mono.fromRunnable(() -> {
            // Log the message being sent
            logger.info("Sending message to topic '{}': {}", topic, message);
            kafkaTemplate.send(topic, message);
            logger.info("Message sent successfully.");
        }).then();
    }

}
