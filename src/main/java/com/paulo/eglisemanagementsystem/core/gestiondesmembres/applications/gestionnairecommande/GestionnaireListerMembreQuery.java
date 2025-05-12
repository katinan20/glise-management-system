package com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.gestionnairecommande;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.gestionnaire.GestionnaireRequete;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.ports.MembreRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.query.ListerMembre;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.vm.MembreEssentielVM;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.exceptions.NonTrouverMembre;

import java.util.List;

/**
 * @author katinan.toure 12/05/2025 09:01
 * @project eglise-management-system
 */
public class GestionnaireListerMembreQuery implements GestionnaireRequete<List<MembreEssentielVM>, Void> {

    private final ListerMembre listerMembre;

    public GestionnaireListerMembreQuery(MembreRepositoryPort membreRepositoryPort) {
        listerMembre = new ListerMembre(membreRepositoryPort);
    }


    @Override
    public List<MembreEssentielVM> query(Void var) throws NonTrouverMembre {
        return this.listerMembre.listerMembres();
    }
}
