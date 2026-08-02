package com.helios.WorkOrder.infrastructure.persistency.implementations;

import com.helios.WorkOrder.core.domain.WorkOrder;
import com.helios.WorkOrder.core.repository.WorkOrderRepository;
import com.helios.WorkOrder.infrastructure.mapper.WorkOrderMap;
import com.helios.WorkOrder.infrastructure.persistency.entities.WorkOrderEntity;
import com.helios.WorkOrder.infrastructure.persistency.repositories.JpaWorkOrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<WorkOrder> findWorkOrderById(Long id){
        return workOrderRepository.findById(id).map(workOrderMap::toCoreEntity);
    }

    @Override
    public List<WorkOrder> listAllWorkOrder(){
        List<WorkOrderEntity> workOrderEntities = workOrderRepository.findAll();
        return workOrderMap.listToCore(workOrderEntities);
    }

    @Override
    public List<WorkOrder> findAllWorkOrderPerServiceId(Long id) {
        List<WorkOrderEntity> orders = workOrderRepository.findAllByServiceId(id);
        return workOrderMap.listToCore(orders);
    }
}
