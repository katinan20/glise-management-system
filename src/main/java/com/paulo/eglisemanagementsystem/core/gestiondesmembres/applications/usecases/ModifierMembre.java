package com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.usecases;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.commande.ModifierMembreCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.ports.MembreRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite.Membres;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.exceptions.MembreException;

import java.util.Optional;
import java.util.UUID;

/**
 * @author katinan.toure 09/05/2025 17:29
 * @project eglise-management-system
 */


public class ModifierMembre {

    private final MembreRepositoryPort membreRepositoryPort;

    public ModifierMembre(MembreRepositoryPort membreRepositoryPort) {
        this.membreRepositoryPort = membreRepositoryPort;
    }
    public Membres modifier(ModifierMembreCommande commande){
        Membres membre = membreRepositoryPort.recupererParId(commande.getId())
                .orElseThrow(() -> new MembreException("Membre introuvable avec l'ID : " + commande.getId()));
        membre.setNom(commande.getNom());
        membre.setPrenom(commande.getPrenom());
        membre.setEmail(commande.getEmail());
        membre.setTelephone(commande.getTelephone());
        membre.setAdresse(commande.getAdresse());
        membre.setSexe(commande.getSexe());
        membre.setDateNaissance(commande.getDateNaissance());
        membre.setDateAdhesion(commande.getDateAdhesion());
        membre.setActif(true);
        membreRepositoryPort.enregistrer(membre);

        return membre;
    }

}
