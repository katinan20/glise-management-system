package com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.query;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.ports.MembreRepositoryPort;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.vm.MembreDetailVM;

import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 13:22
 * @project eglise-management-system
 */
public class RecupererParId {

    private final MembreRepositoryPort membreRepositoryPort;

    public RecupererParId(MembreRepositoryPort membreRepositoryPort) {
        this.membreRepositoryPort = membreRepositoryPort;
    }

    public MembreDetailVM recupererParId(UUID id) {
        return this.membreRepositoryPort.recuperMembreDetailVMParId(id);
    }

}
