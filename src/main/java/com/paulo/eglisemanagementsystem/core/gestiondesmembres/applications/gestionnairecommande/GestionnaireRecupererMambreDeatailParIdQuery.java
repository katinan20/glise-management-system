package com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.gestionnairecommande;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.gestionnaire.GestionnaireRequete;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.ports.MembreRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.query.RecupererParId;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.vm.MembreDetailVM;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.exceptions.NonTrouverMembre;

import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 13:29
 * @project eglise-management-system
 */
public class GestionnaireRecupererMambreDeatailParIdQuery implements GestionnaireRequete<MembreDetailVM, UUID> {

   private final RecupererParId recupererParId;

    public GestionnaireRecupererMambreDeatailParIdQuery(MembreRepositoryPort membreRepositoryPort) {
        recupererParId = new RecupererParId(membreRepositoryPort);
    }

    @Override
    public MembreDetailVM query(UUID var) throws NonTrouverMembre {
        return this.recupererParId.recupererParId(var);
    }
}
