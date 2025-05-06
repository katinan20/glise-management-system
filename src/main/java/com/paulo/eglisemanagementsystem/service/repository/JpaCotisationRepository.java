package com.paulo.eglisemanagementsystem.service.repository;

import com.paulo.eglisemanagementsystem.service.tables.CotisationTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 10:58
 * @project eglise-management-system
 */
public interface JpaCotisationRepository extends JpaRepository<CotisationTable, UUID> {
}
