package com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.query;

import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.port.GroupeRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.vm.ListerGroupeDetailVM;

import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 23:11
 * @project eglise-management-system
 */
public class ListerGroupeParId {

    private final GroupeRepositoryPort groupeRepositoryPort;

    public ListerGroupeParId(GroupeRepositoryPort groupeRepositoryPort) {
        this.groupeRepositoryPort = groupeRepositoryPort;
    }

    public ListerGroupeDetailVM listerGroupeParId(UUID id) {
        return this.groupeRepositoryPort.recuperGroupeDetailParId(id);
    }
}
