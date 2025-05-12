package com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.query;

import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.port.GroupeRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.vm.ListerGroupeEssentielVM;

import java.util.List;

/**
 * @author katinan.toure 12/05/2025 23:00
 * @project eglise-management-system
 */
public class ListerGroupe {
    private final GroupeRepositoryPort groupeRepositoryPort;

    public ListerGroupe(GroupeRepositoryPort groupeRepositoryPort) {
        this.groupeRepositoryPort = groupeRepositoryPort;
    }

    public List<ListerGroupeEssentielVM> lister(){
        return this.groupeRepositoryPort.liste();
    }
}
