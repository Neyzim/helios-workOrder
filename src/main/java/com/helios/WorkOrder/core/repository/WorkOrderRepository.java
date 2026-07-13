package com.helios.WorkOrder.core.repository;

import com.helios.WorkOrder.core.domain.WorkOrder;


public interface WorkOrderRepository {

    WorkOrder save(WorkOrder workOrder);
}
