package com.kafka.models;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Topic {
    String name;
    Queue<String> messages;

    public Topic(String name) {
        this.name = name;
        messages = new ConcurrentLinkedQueue<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean publish(String message){
        try {
            this.messages.add(message);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public String consume(){
        return messages.poll();
    }
}
