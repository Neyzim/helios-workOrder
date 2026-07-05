package com.helios.WorkOrder.infrastructure.config.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class WorkOrderConsumerConfig {

    @KafkaListener(
            topics = "workorder-topic",
            groupId = "workorder-consumer-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(){
        //TODO
    }
}
