package com.paulo.eglisemanagementsystem.service.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 01:30
 * @project eglise-management-system
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "membre")
public class MembreTable extends BaseEntityTable {

    @Id
    private UUID id;

    @NotBlank(message = "Le nom est obligatoire")
    @Column(name = "nom")
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire")
    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @NotBlank(message = "Le genre est obligatoire")
    @Column(name = "sexe")
    private String sexe;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "telephone")
    private String telephone;

    @Email(message = "Email invalide")
    @Column(name = "email")
    private String email;

    @Column(name = "date_adhesion")
    private LocalDate dateAdhesion;

    @Column(name = "actif")
    private Boolean actif;


}
