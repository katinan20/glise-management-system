package com.paulo.eglisemanagementsystem.service.interfaces.facade.impl;

import com.paulo.eglisemanagementsystem.core.common.GestionnaireCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.commande.CreerGroupeCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.commande.ModifierGroupeCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.gestionnairecommande.GestionnaireCreerGroupeCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.gestionnairecommande.GestionnaireModifierGroupeCpmmande;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.gestionnairecommande.gestionnaireSuprimerParIdCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.port.GroupeRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.entite.Groupe;
import com.paulo.eglisemanagementsystem.service.interfaces.facade.GroupeUseCaseFacade;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 15:30
 * @project eglise-management-system
 */

@Service
public class GroupeUseCaseFacadeImpl implements GroupeUseCaseFacade {
    private final GestionnaireCommande<Groupe, CreerGroupeCommande> creerGroupeCommande;
    private final GestionnaireCommande<Groupe, ModifierGroupeCommande> modifierGroupeCommande;
    private final GestionnaireCommande<Groupe, UUID> supprimerGroupeCommande;

    public GroupeUseCaseFacadeImpl(GroupeRepositoryPort groupeRepositoryPort) {
        creerGroupeCommande = new GestionnaireCreerGroupeCommande(groupeRepositoryPort);
        modifierGroupeCommande = new GestionnaireModifierGroupeCpmmande(groupeRepositoryPort);
        supprimerGroupeCommande = new gestionnaireSuprimerParIdCommande(groupeRepositoryPort);
    }

    @Override
    public void creer(CreerGroupeCommande commande) {
        this.creerGroupeCommande.executer(commande);
    }

    @Override
    public void modifier(ModifierGroupeCommande commande) {
        this.modifierGroupeCommande.executer(commande);
    }

    @Override
    public void supprimer(UUID id) {
        this.supprimerGroupeCommande.executer(id);
    }
}
