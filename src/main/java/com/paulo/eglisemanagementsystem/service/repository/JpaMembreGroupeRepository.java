package com.paulo.eglisemanagementsystem.service.repository;

import com.paulo.eglisemanagementsystem.service.tables.MembreGroupeTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 11:00
 * @project eglise-management-system
 */
public interface JpaMembreGroupeRepository extends JpaRepository<MembreGroupeTable, UUID> {
}
