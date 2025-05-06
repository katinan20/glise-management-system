package com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.usecases;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.commande.CreerMembresCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.ports.MembreRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite.Membres;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.exceptions.MembreException;

import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 11:56
 * @project eglise-management-system
 */
public class CreerMembre {

    private final MembreRepositoryPort membreRepositoryPort;

    public CreerMembre(MembreRepositoryPort membreRepositoryPort) {
        this.membreRepositoryPort = membreRepositoryPort;
    }

    public void ajouter(CreerMembresCommande commande){

        this.verificationEmail(commande.getEmail());
        this.verificationPhone(commande.getTelephone());
        Membres membres = this.generer(commande);
        this.membreRepositoryPort.enregistrer(membres);
    }

    private void verificationPhone(String telephone) {
        boolean isExiste = this.membreRepositoryPort.findByTelephone(telephone);
        if(isExiste){
            throw new MembreException("ce numéro de téléphone existe déjà !");
        }
    }

    private void verificationEmail(String email) {
        boolean isExiste = this.membreRepositoryPort.findByEmail(email);
        if(isExiste){
            throw new MembreException("Cet email existe !");
        }
    }

    private Membres generer(CreerMembresCommande commande) {
        Membres membre = new Membres();
        membre.setId(UUID.randomUUID());
        membre.setNom(commande.getNom());
        membre.setPrenom(commande.getPrenom());
        membre.setEmail(commande.getEmail());
        membre.setTelephone(commande.getTelephone());
        membre.setAdresse(commande.getAdresse());
        membre.setDateNaissance(commande.getDateNaissance());
        membre.setSexe(commande.getSexe());
        membre.setActif(true);
        membre.setDateAdhesion(commande.getDateAdhesion());
        return membre;
    }

}
