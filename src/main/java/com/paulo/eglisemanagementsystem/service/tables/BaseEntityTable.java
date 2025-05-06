package com.paulo.eglisemanagementsystem.service.tables;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @author katinan.toure 03/05/2025 01:50
 * @project eglise-management-system
 */

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class BaseEntityTable {

    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    @PrePersist
    @CreationTimestamp
    @Column(name = "created_at")
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    @UpdateTimestamp
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
