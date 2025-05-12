package com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.usecase;

import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.commande.CreerGroupeCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.port.GroupeRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.exception.GroupeException;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.entite.Groupe;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite.Membres;

import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 14:49
 * @project eglise-management-system
 */
public class CreerGroupe {

    private final GroupeRepositoryPort groupeRepositoryPort;

    public CreerGroupe(GroupeRepositoryPort groupeRepositoryPort) {
        this.groupeRepositoryPort = groupeRepositoryPort;
    }

    public Membres creer(CreerGroupeCommande commande){
        this.existeByName(commande.getNom());
        Groupe generer = this.generer(commande);
        this.groupeRepositoryPort.enregister(generer);
        return null;
    }

        private Groupe generer(CreerGroupeCommande commande) {
            Groupe groupe = new Groupe();
            groupe.setId(UUID.randomUUID());
            groupe.setNom(commande.getNom());
            groupe.setDescription(commande.getDescription());
            groupe.setCode(commande.getCode());
            return groupe;
    }

    private void existeByName(String name) {
        boolean existe = this.groupeRepositoryPort.existeByNom(name);
        if (existe) {
            throw new GroupeException("Un group avec ce nom existe déjà !");
        }

    }
}
