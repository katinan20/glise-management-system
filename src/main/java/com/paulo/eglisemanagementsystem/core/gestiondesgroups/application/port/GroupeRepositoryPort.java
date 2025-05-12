package com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.port;

import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.vm.ListerGroupeDetailVM;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.vm.ListerGroupeEssentielVM;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.entite.Groupe;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 14:50
 * @project eglise-management-system
 */
public interface GroupeRepositoryPort {
    void enregister(Groupe generer);

    boolean existeByNom(String name);

    Optional<Groupe> recupererPArId(UUID id);

    void suprimerPrId(UUID id);

    List<ListerGroupeEssentielVM> liste();

    ListerGroupeDetailVM recuperGroupeDetailParId(UUID id);
}
