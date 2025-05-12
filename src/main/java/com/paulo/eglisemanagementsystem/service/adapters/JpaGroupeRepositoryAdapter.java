package com.paulo.eglisemanagementsystem.service.adapters;

import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.port.GroupeRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.vm.ListerGroupeDetailVM;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.vm.ListerGroupeEssentielVM;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.entite.Groupe;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.exception.NonTrouverGroupe;
import com.paulo.eglisemanagementsystem.service.mappers.GroupeMappers;
import com.paulo.eglisemanagementsystem.service.repository.JpaGroupeRepository;
import com.paulo.eglisemanagementsystem.service.tables.GroupeTable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 15:17
 * @project eglise-management-system
 */
@Repository
public class JpaGroupeRepositoryAdapter implements GroupeRepositoryPort {

    private  final JpaGroupeRepository jpaGroupeRepository;
    private final GroupeMappers groupeMappers;

    public JpaGroupeRepositoryAdapter(JpaGroupeRepository jpaGroupeRepository) {
        this.jpaGroupeRepository = jpaGroupeRepository;
        groupeMappers = GroupeMappers.INSTANCE;
    }

    @Override
    public void enregister(Groupe generer) {
        GroupeTable groupeTable = this.groupeMappers.groupeVersGroupeTable(generer);
        this.jpaGroupeRepository.save(groupeTable);
    }

    @Override
    public boolean existeByNom(String name) {
        return this.jpaGroupeRepository.existsByNom(name);
    }

    @Override
    public Optional<Groupe> recupererPArId(UUID id) {
        GroupeTable groupe = this.jpaGroupeRepository.findById(id).orElseThrow(
                ()-> new NonTrouverGroupe("Groupe not found"));
        return Optional.of(groupeMappers.groupeTableVersGroupe(groupe));
    }

    @Override
    public void suprimerPrId(UUID id) {
        this.jpaGroupeRepository.deleteById(id);
    }

    @Override
    public List<ListerGroupeEssentielVM> liste() {
        List<GroupeTable> groupeTable = this.jpaGroupeRepository.findAll();
        return groupeTable.stream()
                .map(groupeMappers::groupeTableVersGroupeEssentielVM)
                .toList();
    }

    @Override
    public ListerGroupeDetailVM recuperGroupeDetailParId(UUID id) {
        GroupeTable groupeTable = this.jpaGroupeRepository.findById(id).orElseThrow(
                ()-> new NonTrouverGroupe("Groupe not found")
        );
        return this.groupeMappers.groupeTableVersGroupeDetailVM(groupeTable);
    }
}
