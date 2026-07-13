package com.helios.WorkOrder.infrastructure.persistency.implementations;

import com.helios.WorkOrder.core.domain.WorkOrder;
import com.helios.WorkOrder.core.repository.WorkOrderRepository;
import com.helios.WorkOrder.infrastructure.mapper.WorkOrderMap;
import com.helios.WorkOrder.infrastructure.persistency.entities.WorkOrderEntity;
import com.helios.WorkOrder.infrastructure.persistency.repositories.JpaWorkOrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public class WorkOrderRepositoryImpl implements WorkOrderRepository {

    private final JpaWorkOrderRepository workOrderRepository;
    private final WorkOrderMap workOrderMap;

    public WorkOrderRepositoryImpl(JpaWorkOrderRepository workOrderRepository, WorkOrderMap workOrderMap) {
        this.workOrderRepository = workOrderRepository;
        this.workOrderMap = workOrderMap;
    }

    @Override
    public WorkOrder save(WorkOrder workOrder) {
        WorkOrderEntity entity = workOrderMap.toInfraEntity(workOrder);
        WorkOrderEntity savedWorkOrder = workOrderRepository.save(entity);
        return workOrderMap.toCoreEntity(savedWorkOrder);
    }
}
