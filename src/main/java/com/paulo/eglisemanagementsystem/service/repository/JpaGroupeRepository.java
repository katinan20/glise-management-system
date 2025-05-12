package com.paulo.eglisemanagementsystem.service.repository;

import com.paulo.eglisemanagementsystem.service.tables.GroupeTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 10:59
 * @project eglise-management-system
 */
public interface JpaGroupeRepository extends JpaRepository<GroupeTable, UUID> {
    boolean existsByNom(String name);
}
