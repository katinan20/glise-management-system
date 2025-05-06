package com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.gestionnairecommande;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.commande.CreerMembresCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.gestionnaire.GestionnaireCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.ports.MembreRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.usecases.CreerMembre;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite.Membres;

/**
 * @author katinan.toure 03/05/2025 12:33
 * @project eglise-management-system
 */
public class GestionnaireCreerMembreCommande implements GestionnaireCommande<CreerMembresCommande> {

    private final CreerMembre creerMembre;

    public GestionnaireCreerMembreCommande(MembreRepositoryPort membreRepositoryPort) {
        creerMembre = new CreerMembre(membreRepositoryPort);
    }

    @Override
    public Membres executer(CreerMembresCommande var) {
        this.creerMembre.ajouter(var);
        return null;
    }
}
