package com.paulo.eglisemanagementsystem.core.common.objetvalue;

import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @author katinan.toure 03/05/2025 11:39
 * @project eglise-management-system
 */
public class BasseEntity {
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
