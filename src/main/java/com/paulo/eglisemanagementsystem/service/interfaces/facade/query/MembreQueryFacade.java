package com.paulo.eglisemanagementsystem.service.interfaces.facade.query;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.vm.MembreDetailVM;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.vm.MembreEssentielVM;

import java.util.List;
import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 09:10
 * @project eglise-management-system
 */
public interface MembreQueryFacade {
    List<MembreEssentielVM> lister();
    MembreDetailVM recupererParId(UUID id);
}
