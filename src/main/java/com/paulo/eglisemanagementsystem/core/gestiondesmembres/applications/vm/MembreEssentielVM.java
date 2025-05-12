package com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.vm;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 08:45
 * @project eglise-management-system
 */
@Getter
@Setter
public class MembreEssentielVM {
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
}
