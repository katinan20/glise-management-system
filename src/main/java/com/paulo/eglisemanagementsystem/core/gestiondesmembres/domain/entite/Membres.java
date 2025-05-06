package com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite;

import com.paulo.eglisemanagementsystem.core.common.objetvalue.BasseEntity;
import com.paulo.eglisemanagementsystem.core.gestiondesactivites.domain.entite.ParticipationActivite;
import com.paulo.eglisemanagementsystem.core.gestiondescotisation.domain.entite.Cotisation;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.entite.Groupe;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.objectvalues.MembreGroupe;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author katinan.toure 02/05/2025 23:38
 * @project eglise-management-system
 */
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
    private Set<MembreGroupe> groupes = new HashSet<>();
    private Set<ParticipationActivite> participations = new HashSet<>();
    private Set<Cotisation> cotisations = new HashSet<>();

    public Membres() {
    }

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(LocalDate dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Set<MembreGroupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(Set<MembreGroupe> groupes) {
        this.groupes = groupes;
    }

    public Set<ParticipationActivite> getParticipations() {
        return participations;
    }

    public void setParticipations(Set<ParticipationActivite> participations) {
        this.participations = participations;
    }

    public Set<Cotisation> getCotisations() {
        return cotisations;
    }

    public void setCotisations(Set<Cotisation> cotisations) {
        this.cotisations = cotisations;
    }

    // Méthodes utilitaires
    public void addGroupe(Groupe groupe, String role) {
        MembreGroupe membreGroupe = new MembreGroupe();
        membreGroupe.setMembre(this);
        membreGroupe.setGroupe(groupe);
        membreGroupe.setRole(role);
        membreGroupe.setDateAdhesion(LocalDate.now());
        groupes.add(membreGroupe);
    }

    public void removeGroupe(Groupe groupe) {
        groupes.removeIf(membreGroupe -> membreGroupe.getGroupe().equals(groupe));
    }

    // Méthode pour obtenir le nom complet
    public String getNomComplet() {
        return prenom + " " + nom;
    }


}


