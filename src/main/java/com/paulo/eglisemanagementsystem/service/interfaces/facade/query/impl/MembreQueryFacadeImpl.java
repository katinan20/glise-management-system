package com.paulo.eglisemanagementsystem.service.interfaces.facade.query.impl;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.gestionnaire.GestionnaireRequete;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.gestionnairecommande.GestionnaireListerMembreQuery;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.gestionnairecommande.GestionnaireRecupererMambreDeatailParIdQuery;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.ports.MembreRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.vm.MembreDetailVM;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.vm.MembreEssentielVM;
import com.paulo.eglisemanagementsystem.service.interfaces.facade.query.MembreQueryFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 09:12
 * @project eglise-management-system
 */

@Service
public class MembreQueryFacadeImpl implements MembreQueryFacade {

    private final GestionnaireRequete<List<MembreEssentielVM>, Void> listeMembreRequete;
    private final GestionnaireRequete<MembreDetailVM, UUID> recuppererParIdMembreRequete;

    public MembreQueryFacadeImpl(MembreRepositoryPort membreRepositoryPort) {
        listeMembreRequete = new GestionnaireListerMembreQuery(membreRepositoryPort);
        recuppererParIdMembreRequete = new GestionnaireRecupererMambreDeatailParIdQuery(membreRepositoryPort);
    }


    @Override
    public List<MembreEssentielVM> lister() {
        return listeMembreRequete.query(null);
    }

    @Override
    public MembreDetailVM recupererParId(UUID id) {
        return this.recuppererParIdMembreRequete.query(id);
    }
}
