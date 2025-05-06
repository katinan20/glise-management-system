package com.paulo.eglisemanagementsystem.service.adapters;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.ports.MembreRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite.Membres;
import com.paulo.eglisemanagementsystem.service.mappers.MembreMappers;
import com.paulo.eglisemanagementsystem.service.repository.JpaMembreRepository;
import com.paulo.eglisemanagementsystem.service.tables.MembreTable;
import org.springframework.stereotype.Repository;

/**
 * @author katinan.toure 03/05/2025 12:40
 * @project eglise-management-system
 */
@Repository
public class JpaMembreGroupeRepositoryAdapter implements MembreRepositoryPort {

    private final JpaMembreRepository jpaMembreRepository;
    private final MembreMappers membreMappers;

    public JpaMembreGroupeRepositoryAdapter(JpaMembreRepository jpaMembreRepository) {
        this.jpaMembreRepository = jpaMembreRepository;
        membreMappers = MembreMappers.INSTANCE;
    }


    @Override
    public boolean findByTelephone(String telephone) {
        return this.jpaMembreRepository.existsByTelephone(telephone);
    }

    @Override
    public boolean findByEmail(String email) {
        return this.jpaMembreRepository.existsByEmail(email);
    }

    @Override
    public void enregistrer(Membres membres) {
        MembreTable membreTable = this.membreMappers.membreCommandeVersMembreTable(membres);
        this.jpaMembreRepository.save(membreTable);
    }
}
