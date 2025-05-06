package com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.objectvalues;

import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.entite.Groupe;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite.Membres;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author katinan.toure 03/05/2025 00:03
 * @project eglise-management-system
 */
public class MembreGroupe {
    private Membres membre;
    private Groupe groupe;
    private String role;
    private LocalDate dateAdhesion;

    public MembreGroupe() {
    }

    public Membres getMembre() {
        return membre;
    }

    public void setMembre(Membres membre) {
        this.membre = membre;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(LocalDate dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }
}
