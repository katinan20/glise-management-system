package com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.usecases;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.ports.MembreRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite.Membres;

import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 08:07
 * @project eglise-management-system
 */
public class SupprimerMembre {
    private final MembreRepositoryPort membreRepositoryPort;

    public SupprimerMembre(MembreRepositoryPort membreRepositoryPort) {
        this.membreRepositoryPort = membreRepositoryPort;
    }

    public Membres supprimerMembre(UUID membreId) {
        this.membreRepositoryPort.supprimer(membreId);
        return null;
    }
}
