package com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.usecase;

import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.commande.ModifierGroupeCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.port.GroupeRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.entite.Groupe;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.exception.NonTrouverGroupe;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.commande.ModifierMembreCommande;

/**
 * @author katinan.toure 12/05/2025 16:21
 * @project eglise-management-system
 */
public class ModifierGroupe {

    private final GroupeRepositoryPort groupeRepositoryPort;

    public ModifierGroupe(GroupeRepositoryPort groupeRepositoryPort) {
        this.groupeRepositoryPort = groupeRepositoryPort;
    }

    public Groupe modifier(ModifierGroupeCommande commande){
        Groupe groupe = this.groupeRepositoryPort.recupererPArId(commande.getId()).orElseThrow(
                ()-> new NonTrouverGroupe("Aucun groupe n'existe !")
        );
        groupe.setId(groupe.getId());
        groupe.setCode(commande.getCode());
        groupe.setNom(commande.getNom());
        groupe.setDescription(commande.getDescription());

        this.groupeRepositoryPort.enregister(groupe);
        return groupe;

    }
}
