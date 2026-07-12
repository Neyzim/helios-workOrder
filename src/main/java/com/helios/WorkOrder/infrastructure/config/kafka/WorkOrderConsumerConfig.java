package com.helios.WorkOrder.infrastructure.config.kafka;

import com.helios.WorkOrder.core.domain.WorkOrder;
import com.helios.WorkOrder.infrastructure.dto.ServiceEventDto;
import com.helios.WorkOrder.infrastructure.persistency.entities.WorkOrderEntity;
import com.helios.WorkOrder.infrastructure.persistency.service.WorkOrderService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class WorkOrderConsumerConfig {

    private final WorkOrderService service;

    public WorkOrderConsumerConfig(WorkOrderService service) {
        this.service = service;
    }

    @KafkaListener(
            topics = "service-events",
            groupId = "workOrder-consumer-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(ServiceEventDto event){

        service.createBasedOnEvent(event);
    }
}
