package com.helios.WorkOrder.core;

import java.time.LocalDateTime;

public class WorkOrder {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;

    //Received from Kakfa Message
    private Long serviceId;
    private String serviceName;
    private LocalDateTime startedAt;
    private String type;

    public static WorkOrder createNew(Long id, String title, String description, LocalDateTime createdAt, LocalDateTime finishedAt, Long serviceId, String serviceName, LocalDateTime startedAt, String type) {
        WorkOrder workOrder =  new WorkOrder();
        workOrder.id = id;
        workOrder.title = title;
        workOrder.description = description;
        workOrder.createdAt = createdAt;
        workOrder.finishedAt = finishedAt;
        workOrder.serviceId = serviceId;
        workOrder.serviceName = serviceName;
        workOrder.startedAt = startedAt;
        workOrder.type = type;
        return workOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
