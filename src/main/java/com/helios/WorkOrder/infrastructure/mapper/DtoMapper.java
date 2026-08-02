package com.helios.WorkOrder.infrastructure.mapper;

import com.helios.WorkOrder.core.domain.WorkOrder;
import com.helios.WorkOrder.infrastructure.dto.ResponseWorkOrderDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DtoMapper {

    public ResponseWorkOrderDto toResponseDto(WorkOrder workOrder){
        return new ResponseWorkOrderDto(
                workOrder.getServiceId(),
                workOrder.getServiceName(),
                workOrder.getStartedAt(),
                workOrder.getType()
        );
    }

    public List<ResponseWorkOrderDto> toListResponseDto(List<WorkOrder> orders){
        List<ResponseWorkOrderDto> responseWorkOrderDtos = new ArrayList<>();
        for (WorkOrder order : orders){
            ResponseWorkOrderDto dto = new ResponseWorkOrderDto(
                    order.getServiceId(),
                    order.getServiceName(),
                    order.getStartedAt(),
                    order.getType()
            );
            responseWorkOrderDtos.add(dto);
        }
        return responseWorkOrderDtos;
    }
}
