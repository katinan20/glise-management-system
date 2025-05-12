package com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.gestionnairecommande;

import com.paulo.eglisemanagementsystem.core.common.GestionnaireRequetes;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.port.GroupeRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.query.ListerGroupeParId;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.vm.ListerGroupeDetailVM;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.exception.NonTrouverGroupe;

import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 23:16
 * @project eglise-management-system
 */
public class GestionnaireRecupererGroupeDetailQuery implements GestionnaireRequetes<ListerGroupeDetailVM, UUID> {

    private final ListerGroupeParId listerGroupeParId;

    public GestionnaireRecupererGroupeDetailQuery(GroupeRepositoryPort groupeRepositoryPort) {
        listerGroupeParId = new ListerGroupeParId(groupeRepositoryPort);
    }

    @Override
    public ListerGroupeDetailVM query(UUID commande) throws NonTrouverGroupe {
        return this.listerGroupeParId.listerGroupeParId(commande);
    }
}
