package com.boilerplate.reactivekafka.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

@SpringBootTest
public class ReactiveKafkaProducerTest {

    @Autowired
    private ReactiveKafkaProducer producer;

    @Test
    public void testSendMessage() {
        String topic = "reactive-topic";
        String message = "Hello, Kafka!";

        StepVerifier.create(producer.sendMessage(topic, message))
                .verifyComplete();
    }
}