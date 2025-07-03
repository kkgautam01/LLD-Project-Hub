package com.kafka.facade;

import com.kafka.service.Consumer;
import com.kafka.service.Discovery;
import com.kafka.service.Producer;

public class KafkaFacade {
    private final Discovery discovery;
    private final Producer producer;
    private final Consumer consumer;

    public KafkaFacade() {
        this.discovery = new Discovery();
        this.producer = new Producer(discovery);
        this.consumer = new Consumer(discovery);
    }

    public void startConsumerPolling() {
        consumer.initiatePolling();
    }

    public void sendMessage(String topic, String message) {
        producer.addMessage(topic, message);
    }

    public void addTopic(String topic) {
        discovery.addTopic(topic);
    }

    public void stopConsumerPolling() {
        // Optional: if you later add polling stop logic
    }
}
