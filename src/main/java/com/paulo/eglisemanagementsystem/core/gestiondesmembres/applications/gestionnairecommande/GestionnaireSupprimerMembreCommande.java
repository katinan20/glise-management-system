package com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.gestionnairecommande;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.gestionnaire.GestionnaireCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.ports.MembreRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.usecases.SupprimerMembre;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite.Membres;

import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 08:13
 * @project eglise-management-system
 */
public class GestionnaireSupprimerMembreCommande implements GestionnaireCommande<UUID> {

    private final SupprimerMembre supprimerMembre;

    public GestionnaireSupprimerMembreCommande(MembreRepositoryPort membreRepositoryPort) {
        this.supprimerMembre = new SupprimerMembre(membreRepositoryPort);
    }

    @Override
    public Membres executer(UUID id) {
        return this.supprimerMembre.supprimerMembre(id);
    }
}
