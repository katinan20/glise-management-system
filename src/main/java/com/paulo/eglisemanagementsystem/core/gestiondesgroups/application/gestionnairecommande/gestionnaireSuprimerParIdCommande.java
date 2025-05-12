package com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.gestionnairecommande;

import com.paulo.eglisemanagementsystem.core.common.GestionnaireCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.port.GroupeRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.usecase.SupprimerGroupe;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.entite.Groupe;

import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 17:34
 * @project eglise-management-system
 */
public class gestionnaireSuprimerParIdCommande implements GestionnaireCommande<Groupe, UUID> {
    private final SupprimerGroupe supprimerGroupe;

    public gestionnaireSuprimerParIdCommande(GroupeRepositoryPort groupeRepositoryPort) {
        supprimerGroupe = new SupprimerGroupe(groupeRepositoryPort);
    }

    @Override
    public Groupe executer(UUID id) {
        return this.supprimerGroupe.supprimerGroupe(id);
    }
}
