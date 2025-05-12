package com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite;

import com.paulo.eglisemanagementsystem.core.common.objetvalue.BasseEntity;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.entite.Groupe;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.objectvalues.MembreGroupe;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author katinan.toure 02/05/2025 23:38
 * @project eglise-management-system
 */
@Getter
@Setter
public class Membres extends BasseEntity {
    private UUID id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String sexe;
    private String email;
    private String adresse;
    private String telephone;
    private LocalDate dateAdhesion;
    private Boolean actif;

    // Méthodes utilitaires
    public void addGroupe(Groupe groupe, String role) {
        MembreGroupe membreGroupe = new MembreGroupe();
        membreGroupe.setMembre(this);
        membreGroupe.setGroupe(groupe);
        membreGroupe.setRole(role);
        membreGroupe.setDateAdhesion(LocalDate.now());
    }

    // Méthode pour obtenir le nom complet
    public String getNomComplet() {
        return prenom + " " + nom;
    }


}


