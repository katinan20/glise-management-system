package com.paulo.eglisemanagementsystem.factory;

import com.paulo.eglisemanagementsystem.service.repository.JpaGroupeRepository;
import com.paulo.eglisemanagementsystem.service.tables.GroupeTable;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 17:00
 * @project eglise-management-system
 */
@Component
public class GroupeFactory {
    private final JpaGroupeRepository jpaGroupeRepository;

    public GroupeFactory(JpaGroupeRepository jpaGroupeRepository) {
        this.jpaGroupeRepository = jpaGroupeRepository;
    }

    public GroupeTable groupeTable() {
        GroupeTable groupeTable = new GroupeTable();
        groupeTable.setId(UUID.randomUUID());
        groupeTable.setCode(UUID.randomUUID().toString());
        groupeTable.setNom("FOOT");
        groupeTable.setDescription("Organisation des objets");

        this.jpaGroupeRepository.save(groupeTable);
        return groupeTable;
    }
}
