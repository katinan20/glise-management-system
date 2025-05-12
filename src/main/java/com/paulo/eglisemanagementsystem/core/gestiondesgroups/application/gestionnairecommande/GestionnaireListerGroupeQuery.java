package com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.gestionnairecommande;

import com.paulo.eglisemanagementsystem.core.common.GestionnaireRequetes;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.port.GroupeRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.query.ListerGroupe;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.vm.ListerGroupeEssentielVM;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.exception.NonTrouverGroupe;

import java.util.List;

/**
 * @author katinan.toure 12/05/2025 23:04
 * @project eglise-management-system
 */
public class GestionnaireListerGroupeQuery implements GestionnaireRequetes<List<ListerGroupeEssentielVM>, Void> {

    private final ListerGroupe listerGroupe;

    public GestionnaireListerGroupeQuery(GroupeRepositoryPort groupeRepositoryPort) {
        listerGroupe = new ListerGroupe(groupeRepositoryPort);
    }

    @Override
    public List<ListerGroupeEssentielVM> query(Void commande) throws NonTrouverGroupe {
        return this.listerGroupe.lister();
    }
}
