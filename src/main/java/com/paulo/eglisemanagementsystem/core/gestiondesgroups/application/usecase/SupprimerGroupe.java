package com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.usecase;

import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.port.GroupeRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.entite.Groupe;

import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 17:28
 * @project eglise-management-system
 */
public class SupprimerGroupe {

    private final GroupeRepositoryPort groupeRepositoryPort;

    public SupprimerGroupe(GroupeRepositoryPort groupeRepositoryPort) {
        this.groupeRepositoryPort = groupeRepositoryPort;
    }

    public Groupe supprimerGroupe(UUID id) {
        this.groupeRepositoryPort.suprimerPrId(id);
        return null;
    }

}
