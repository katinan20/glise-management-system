package com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.gestionnairecommande;

import com.paulo.eglisemanagementsystem.core.common.GestionnaireCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.commande.CreerGroupeCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.port.GroupeRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.usecase.CreerGroupe;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.entite.Groupe;


/**
 * @author katinan.toure 12/05/2025 15:10
 * @project eglise-management-system
 */
public class GestionnaireCreerGroupeCommande implements GestionnaireCommande<Groupe, CreerGroupeCommande> {

    private final CreerGroupe creerGroupe;

    public GestionnaireCreerGroupeCommande(GroupeRepositoryPort groupeRepositoryPort) {
        creerGroupe = new CreerGroupe(groupeRepositoryPort);
    }

    @Override
    public Groupe executer(CreerGroupeCommande commande) {
        this.creerGroupe.creer(commande);
        return null;
    }
}
