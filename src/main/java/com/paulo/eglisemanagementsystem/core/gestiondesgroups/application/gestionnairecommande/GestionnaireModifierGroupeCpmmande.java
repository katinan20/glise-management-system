package com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.gestionnairecommande;

import com.paulo.eglisemanagementsystem.core.common.GestionnaireCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.commande.ModifierGroupeCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.port.GroupeRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.usecase.ModifierGroupe;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.entite.Groupe;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite.Membres;

import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 16:34
 * @project eglise-management-system
 */
public class GestionnaireModifierGroupeCpmmande implements GestionnaireCommande<Groupe, ModifierGroupeCommande> {

    private final ModifierGroupe modifierGroupe;

    public GestionnaireModifierGroupeCpmmande(GroupeRepositoryPort groupeRepositoryPort) {
        modifierGroupe = new ModifierGroupe(groupeRepositoryPort);
    }

    @Override
    public Groupe executer(ModifierGroupeCommande commande) {
        return this.modifierGroupe.modifier(commande);
    }
}
