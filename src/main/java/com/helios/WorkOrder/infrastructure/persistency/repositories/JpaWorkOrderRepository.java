package com.helios.WorkOrder.infrastructure.persistency.repositories;

import com.helios.WorkOrder.infrastructure.persistency.entities.WorkOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaWorkOrderRepository extends JpaRepository<WorkOrderEntity, Long> {


}
