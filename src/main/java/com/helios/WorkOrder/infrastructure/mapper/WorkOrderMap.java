package com.helios.WorkOrder.infrastructure.mapper;

import com.helios.WorkOrder.core.domain.WorkOrder;
import com.helios.WorkOrder.infrastructure.persistency.entities.WorkOrderEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkOrderMap {

    public WorkOrder toCoreEntity(WorkOrderEntity entity){
        WorkOrder workOrder = WorkOrder.createNew(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getCreatedAt(),
                entity.getFinishedAt(),
                entity.getServiceId(),
                entity.getServiceName(),
                entity.getStartedAt(),
                entity.getType()
        );
        return workOrder;
    }

    public WorkOrderEntity toInfraEntity(WorkOrder coreEntity){
        WorkOrderEntity infraEntity = new WorkOrderEntity(
                coreEntity.getId(),
                coreEntity.getTitle(),
                coreEntity.getDescription(),
                coreEntity.getCreatedAt(),
                coreEntity.getFinishedAt(),
                coreEntity.getServiceId(),
                coreEntity.getServiceName(),
                coreEntity.getStartedAt(),
                coreEntity.getType()
        );
        return infraEntity;
    }

    public List<WorkOrder> listToCore(List<WorkOrderEntity> entity){
        return entity.stream()
                .map(this::toCoreEntity)
                .collect(Collectors.toList());
    }
}
