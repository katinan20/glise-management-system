package com.paulo.eglisemanagementsystem.service.interfaces.facade;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.commande.CreerMembresCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.commande.ModifierMembreCommande;

import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 13:09
 * @project eglise-management-system
 */
public interface MembreUseCaseFacade {
    void creer(CreerMembresCommande commande);
    void modiffier(ModifierMembreCommande commande);
    void supprimer(UUID id);
}
