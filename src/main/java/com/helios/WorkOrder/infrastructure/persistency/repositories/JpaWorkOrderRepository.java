package com.helios.WorkOrder.infrastructure.persistency.repositories;

import com.helios.WorkOrder.core.domain.WorkOrder;
import com.helios.WorkOrder.infrastructure.persistency.entities.WorkOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaWorkOrderRepository extends JpaRepository<WorkOrderEntity, Long> {

    List<WorkOrderEntity> findAllByServiceId(Long serviceId);
}
