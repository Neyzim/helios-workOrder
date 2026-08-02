package com.helios.WorkOrder.infrastructure.persistency.service;

import com.helios.WorkOrder.core.domain.WorkOrder;
import com.helios.WorkOrder.core.repository.WorkOrderRepository;
import com.helios.WorkOrder.infrastructure.dto.ServiceEventDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class WorkOrderService {

    private final WorkOrderRepository workOrderRepository;


    public WorkOrderService(WorkOrderRepository workOrderRepository) {
        this.workOrderRepository = workOrderRepository;
    }

    public void createBasedOnEvent(ServiceEventDto event){
        WorkOrder workOrder =  WorkOrder.createNew(
                null,
                generateTitle(event),
                generateDescrition(event),
                LocalDateTime.now(),
                null,
                event.serviceId(),
                event.serviceName(),
                event.startedAt(),
                event.status()
        );

        workOrderRepository.save(workOrder);

    }

    public String generateTitle(ServiceEventDto service){
        return "Ordem de Serviço - " + service.serviceName();
    }

    public String generateDescrition(ServiceEventDto serviceEventDto){
        return "Gerada automaticamente a partir do evento de tipo: " + serviceEventDto.status();
    }

    public Optional<WorkOrder> searchOrderPerId(Long id){
        Optional<WorkOrder> order = workOrderRepository.findWorkOrderById(id);
        return order;
    }
}
