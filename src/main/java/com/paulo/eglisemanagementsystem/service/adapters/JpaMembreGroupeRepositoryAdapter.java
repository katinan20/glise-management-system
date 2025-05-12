package com.paulo.eglisemanagementsystem.service.adapters;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.ports.MembreRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.vm.MembreDetailVM;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.vm.MembreEssentielVM;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite.Membres;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.exceptions.MembreException;
import com.paulo.eglisemanagementsystem.service.mappers.MembreMappers;
import com.paulo.eglisemanagementsystem.service.repository.JpaMembreRepository;
import com.paulo.eglisemanagementsystem.service.tables.MembreTable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        MembreTable membreTable = this.membreMappers.membreVersMembreTable(membres);
        this.jpaMembreRepository.save(membreTable);
    }

    @Override
    public Optional<Membres> recupererParId(UUID id) {
        MembreTable membreTable = this.jpaMembreRepository.findById(id)
                .orElseThrow(() -> new MembreException("Le membre n esxistenpas !"));
        return Optional.of(membreMappers.membreTableVersMembre(membreTable));
    }

    @Override
    public void supprimer(UUID membreId) {
        this.jpaMembreRepository.deleteById(membreId);
    }

    @Override
    public List<MembreEssentielVM> liste() {
        List<MembreTable> lister = this.jpaMembreRepository.findAll();
    return lister.stream()
            .map(membreMappers::membreTableVersMembreEssentielVM)
            .toList();
    }

    @Override
    public MembreDetailVM recuperMembreDetailVMParId(UUID id) {
        MembreTable membre = this.jpaMembreRepository.findById(id).orElseThrow(
                () -> new MembreException("Le membre n esxistenpas !")
        );
        return this.membreMappers.membreTableVersMembreDetail(membre);
    }
}
