package com.paulo.eglisemanagementsystem.service.repository;

import com.paulo.eglisemanagementsystem.service.tables.MembreTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 11:01
 * @project eglise-management-system
 */
public interface JpaMembreRepository extends JpaRepository<MembreTable, UUID> {

    boolean existsByTelephone(String telephone);

    boolean existsByEmail(String email);
}
