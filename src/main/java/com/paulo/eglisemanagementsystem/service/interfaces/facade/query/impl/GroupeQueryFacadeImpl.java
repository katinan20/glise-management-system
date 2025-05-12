package com.paulo.eglisemanagementsystem.service.interfaces.facade.query.impl;

import com.paulo.eglisemanagementsystem.core.common.GestionnaireRequetes;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.gestionnairecommande.GestionnaireListerGroupeQuery;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.gestionnairecommande.GestionnaireRecupererGroupeDetailQuery;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.port.GroupeRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.vm.ListerGroupeDetailVM;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.vm.ListerGroupeEssentielVM;
import com.paulo.eglisemanagementsystem.service.interfaces.facade.query.GroupeQueryFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 23:34
 * @project eglise-management-system
 */

@Service
public class GroupeQueryFacadeImpl implements GroupeQueryFacade {
    private final GestionnaireRequetes<List<ListerGroupeEssentielVM>, Void> listerGroupeRequetes;
    private final GestionnaireRequetes<ListerGroupeDetailVM, UUID> recupererGroupePArIDRequetes;

    public GroupeQueryFacadeImpl(GroupeRepositoryPort groupeRepositoryPort) {
        listerGroupeRequetes = new GestionnaireListerGroupeQuery(groupeRepositoryPort);
        recupererGroupePArIDRequetes = new GestionnaireRecupererGroupeDetailQuery(groupeRepositoryPort);
    }

    @Override
    public List<ListerGroupeEssentielVM> lister() {
        return this.listerGroupeRequetes.query(null);
    }

    @Override
    public ListerGroupeDetailVM recupererGroupeDetailParId(UUID id) {
        return this.recupererGroupePArIDRequetes.query(id);
    }
}
