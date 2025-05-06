package com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.entite;

import com.paulo.eglisemanagementsystem.core.gestiondesactivites.domain.entite.Activite;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.objectvalues.MembreGroupe;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 00:07
 * @project eglise-management-system
 */
public class Groupe {

    private UUID id;
    private String nom;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Set<MembreGroupe> membres = new HashSet<>();
    private Set<Activite> activites = new HashSet<>();

    public Groupe() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<MembreGroupe> getMembres() {
        return membres;
    }

    public void setMembres(Set<MembreGroupe> membres) {
        this.membres = membres;
    }

    public Set<Activite> getActivites() {
        return activites;
    }

    public void setActivites(Set<Activite> activites) {
        this.activites = activites;
    }
}
