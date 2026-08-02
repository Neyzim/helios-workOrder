package com.helios.WorkOrder.infrastructure.controller;

import com.helios.WorkOrder.core.domain.WorkOrder;
import com.helios.WorkOrder.core.repository.WorkOrderRepository;
import com.helios.WorkOrder.infrastructure.dto.ResponseWorkOrderDto;
import com.helios.WorkOrder.infrastructure.mapper.DtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class WorkOrderController {

    private final WorkOrderRepository workOrderRepository;
    private final DtoMapper mapper;

    public WorkOrderController(WorkOrderRepository workOrderRepository, DtoMapper mapper) {
        this.workOrderRepository = workOrderRepository;
        this.mapper = mapper;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ResponseWorkOrderDto>> listAllWorOrders(){
        List<WorkOrder> orders = workOrderRepository.listAllWorkOrder();
        return ResponseEntity.ok().body(mapper.toListResponseDto(orders));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseWorkOrderDto> findWorkOrderPerId(@PathVariable Long id){
        WorkOrder order = workOrderRepository.findWorkOrderById(id).orElseThrow();
        return ResponseEntity.ok().body(mapper.toResponseDto(order));
    }

    @GetMapping(value = "/service/{serviceId}")
    public ResponseEntity<List<ResponseWorkOrderDto>> listAllWorkOrdersPerServiceId(@PathVariable Long serviceId){
        List<WorkOrder> orders = workOrderRepository.findAllWorkOrderPerServiceId(serviceId);
        return ResponseEntity.ok().body(mapper.toListResponseDto(orders));
    }
}
