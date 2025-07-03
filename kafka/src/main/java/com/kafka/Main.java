package com.kafka;

import com.kafka.facade.KafkaFacade;

public class Main {
    public static void main(String[] args) {
        KafkaFacade kafka = new KafkaFacade();

        kafka.startConsumerPolling();  // hides Consumer and Discovery logic
        addData(kafka);

    }

    public static void addData(KafkaFacade kafka){
        for(int i = 0; i < 5 ; i++) {
            kafka.sendMessage("User", "Linux " + i);
            kafka.sendMessage("User", "Root "+ i);
            kafka.sendMessage("User", "Custom "+ i);

            kafka.sendMessage("Metrics", "Cpu "+ i);
            kafka.sendMessage("Metrics", "Memory "+ i);
            kafka.sendMessage("Metrics", "Cores "+ i);
            kafka.sendMessage("Metrics", "Throughput "+ i);
            kafka.sendMessage("Metrics", "Rpm "+ i);
            kafka.sendMessage("Metrics", "Cache Hit "+ i);
        }
    }

}