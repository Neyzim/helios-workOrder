package com.helios.WorkOrder.infrastructure.persistency.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "work-order")
public class WorkOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public WorkOrderEntity() {
    }

    public WorkOrderEntity(Long id, String title, String description, LocalDateTime createdAt, LocalDateTime finishedAt, Long serviceId, String serviceName, LocalDateTime startedAt, String type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.finishedAt = finishedAt;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.startedAt = startedAt;
        this.type = type;
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
