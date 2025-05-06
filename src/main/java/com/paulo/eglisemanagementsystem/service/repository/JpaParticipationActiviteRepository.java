package com.paulo.eglisemanagementsystem.service.repository;

import com.paulo.eglisemanagementsystem.service.tables.ParticipationActiviteTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 11:02
 * @project eglise-management-system
 */
public interface JpaParticipationActiviteRepository extends JpaRepository<ParticipationActiviteTable, UUID> {
}
