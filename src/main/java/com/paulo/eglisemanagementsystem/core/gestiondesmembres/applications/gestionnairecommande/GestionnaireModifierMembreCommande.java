package com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.gestionnairecommande;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.commande.ModifierMembreCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.gestionnaire.GestionnaireCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.ports.MembreRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.usecases.ModifierMembre;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite.Membres;

/**
 * @author katinan.toure 09/05/2025 18:04
 * @project eglise-management-system
 */
public class GestionnaireModifierMembreCommande implements GestionnaireCommande<ModifierMembreCommande> {

    private final ModifierMembre modifierMembre;

    public GestionnaireModifierMembreCommande(MembreRepositoryPort membreRepositoryPort) {
        modifierMembre = new ModifierMembre(membreRepositoryPort);
    }

    @Override
    public Membres executer(ModifierMembreCommande commande) {
        return modifierMembre.modifier(commande);
    }
}
