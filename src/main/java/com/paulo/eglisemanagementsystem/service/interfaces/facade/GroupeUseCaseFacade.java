package com.paulo.eglisemanagementsystem.service.interfaces.facade;

import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.commande.CreerGroupeCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.commande.ModifierGroupeCommande;

import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 15:28
 * @project eglise-management-system
 */
public interface GroupeUseCaseFacade {
    void creer(CreerGroupeCommande commande);
    void modifier(ModifierGroupeCommande commande);
    void supprimer(UUID id);
}
