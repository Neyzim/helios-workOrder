package com.helios.WorkOrder.infrastructure.dto;

import java.time.LocalDateTime;

public record ResponseWorkOrderDto(
        Long serviceId,
        String serviceName,
        LocalDateTime startedAt,
        String type
) {
}
