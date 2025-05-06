package com.paulo.eglisemanagementsystem.service.repository;

import com.paulo.eglisemanagementsystem.service.tables.ActiviteTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 10:56
 * @project eglise-management-system
 */
public interface JpaActveRepository extends JpaRepository<ActiviteTable, UUID> {
}
