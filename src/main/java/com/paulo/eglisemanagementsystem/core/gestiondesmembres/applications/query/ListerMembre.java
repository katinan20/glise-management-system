package com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.query;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.ports.MembreRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.vm.MembreEssentielVM;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite.Membres;

import java.util.List;

/**
 * @author katinan.toure 12/05/2025 08:47
 * @project eglise-management-system
 */
public class ListerMembre {

    private final MembreRepositoryPort membreRepositoryPort;

    public ListerMembre(MembreRepositoryPort membreRepositoryPort) {
        this.membreRepositoryPort = membreRepositoryPort;
    }

    public List<MembreEssentielVM> listerMembres() {
       return this.membreRepositoryPort.liste();
    }
}
