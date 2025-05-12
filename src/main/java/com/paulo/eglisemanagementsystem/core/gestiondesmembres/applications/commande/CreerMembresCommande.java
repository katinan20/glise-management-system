package com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.commande;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author katinan.toure 03/05/2025 11:48
 * @project eglise-management-system
 */

@Getter
@Setter
public class CreerMembresCommande {
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String sexe;
    private String email;
    private String adresse;
    private String telephone;
    private LocalDate dateAdhesion;
    private Boolean actif;

}
