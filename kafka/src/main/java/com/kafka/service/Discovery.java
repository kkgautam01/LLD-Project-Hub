package com.kafka.service;

import com.kafka.models.Topic;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Discovery {
    ConcurrentHashMap<String, Topic> topicDiscovery = new ConcurrentHashMap();

    public void addTopic(String topicName){
        if(!topicDiscovery.containsKey(topicName))
            topicDiscovery.put(topicName, new Topic(topicName));
    }

    public Topic getTopic(String topicName){
        return topicDiscovery.get(topicName);
    }

    public boolean isTopicExist(String topicName){
        return topicDiscovery.containsKey(topicName)?  true :  false;
    }

    public Set<String> getAllTopics(){
        return topicDiscovery.keySet();
    }
}
