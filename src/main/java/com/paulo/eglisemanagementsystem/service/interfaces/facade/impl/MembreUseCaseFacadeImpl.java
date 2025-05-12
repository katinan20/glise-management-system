package com.paulo.eglisemanagementsystem.service.interfaces.facade.impl;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.commande.CreerMembresCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.commande.ModifierMembreCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.gestionnaire.GestionnaireCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.gestionnairecommande.GestionnaireCreerMembreCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.gestionnairecommande.GestionnaireModifierMembreCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.gestionnairecommande.GestionnaireSupprimerMembreCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.ports.MembreRepositoryPort;
import com.paulo.eglisemanagementsystem.service.interfaces.facade.MembreUseCaseFacade;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 13:10
 * @project eglise-management-system
 */

@Service
public class MembreUseCaseFacadeImpl implements MembreUseCaseFacade {

    private final GestionnaireCommande<CreerMembresCommande> creerMembresCommande;
    private final GestionnaireCommande<ModifierMembreCommande> modifierMembreCommand;
    private final GestionnaireCommande<UUID> supprimerMembreCommand;


    public MembreUseCaseFacadeImpl(MembreRepositoryPort membreRepositoryPort) {
        creerMembresCommande = new GestionnaireCreerMembreCommande(membreRepositoryPort);
        modifierMembreCommand = new GestionnaireModifierMembreCommande(membreRepositoryPort);
        supprimerMembreCommand = new GestionnaireSupprimerMembreCommande(membreRepositoryPort);
    }

    @Override
    public void creer(CreerMembresCommande commande) {
        this.creerMembresCommande.executer(commande);
    }

    @Override
    public void modiffier(ModifierMembreCommande commande) {
        this.modifierMembreCommand.executer(commande);
    }

    @Override
    public void supprimer(UUID id) {
       this.supprimerMembreCommand.executer(id);
    }
}
