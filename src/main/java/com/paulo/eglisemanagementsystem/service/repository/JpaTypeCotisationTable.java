package com.paulo.eglisemanagementsystem.service.repository;

import com.paulo.eglisemanagementsystem.service.tables.TypeCotisationTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 11:04
 * @project eglise-management-system
 */
public interface JpaTypeCotisationTable extends JpaRepository<TypeCotisationTable, UUID> {
}
