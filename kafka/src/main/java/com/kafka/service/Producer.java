package com.kafka.service;

import com.kafka.models.Topic;

public class Producer {
    Discovery discovery;

    public Producer(Discovery discovery) {
        this.discovery = discovery;
    }

    public void addMessage(String topicName, String message){
        if(!discovery.isTopicExist(topicName)){
            discovery.addTopic(topicName);
        }

        Topic topic = discovery.getTopic(topicName);
        if(!topic.publish(message))
            System.out.println("Failed to add message to the topic : " + topicName);
    }
}
