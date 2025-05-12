package com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.ports;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.vm.MembreDetailVM;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.vm.MembreEssentielVM;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite.Membres;
import com.paulo.eglisemanagementsystem.service.tables.MembreTable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 11:56
 * @project eglise-management-system
 */
public interface MembreRepositoryPort {
    boolean findByTelephone(String telephone);

    boolean findByEmail(String email);

    void enregistrer(Membres membres);

    Optional<Membres> recupererParId(UUID id);

    void supprimer(UUID membreId);

    List<MembreEssentielVM> liste();

    MembreDetailVM recuperMembreDetailVMParId(UUID id);
}
