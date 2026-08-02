package com.helios.WorkOrder.core.repository;

import com.helios.WorkOrder.core.domain.WorkOrder;

import java.util.List;
import java.util.Optional;


public interface WorkOrderRepository {

    WorkOrder save(WorkOrder workOrder);

    Optional<WorkOrder> findWorkOrderById(Long id);

    List<WorkOrder> listAllWorkOrder();

    List<WorkOrder> findAllWorkOrderPerServiceId(Long id);
}
