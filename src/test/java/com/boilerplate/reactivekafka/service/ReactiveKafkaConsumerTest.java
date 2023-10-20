package com.boilerplate.reactivekafka.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ReactiveKafkaConsumerTest {

    @Spy
    @InjectMocks
    private ReactiveKafkaConsumer consumer;

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    public ReactiveKafkaConsumerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListen() {
        String message = "Hello, Kafka!";
        consumer.listen(message);
        verify(consumer, times(1)).listen(message);
    }
}
