package com.kafka.service;

import com.kafka.models.Topic;

import java.util.Set;


public class Consumer {
    Discovery discovery ;

    public Consumer(Discovery discovery) {
        this.discovery = discovery;
    }

    public String getMessage(String topicName){
        Topic topic = discovery.getTopic(topicName);
        return topic.consume();
    }

    public void initiatePolling(){
        new Thread(() -> {

            while (true) {
                Set<String> topicNames = discovery.getAllTopics();
                for(String topicName : topicNames){
                    String message = getMessage(topicName);
                    if(message != null && !message.isEmpty())
                        System.out.println("Topic : " + topicName + ", Message : " + message);
                }

                try {
                    Thread.sleep(100); // poll every 100ms
                } catch (InterruptedException e) {
                    break;
                }
            }

        }).start();
    }
}
