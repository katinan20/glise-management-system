package com.paulo.eglisemanagementsystem.service.interfaces.facade.query;

import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.vm.ListerGroupeDetailVM;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.vm.ListerGroupeEssentielVM;

import java.util.List;
import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 23:31
 * @project eglise-management-system
 */
public interface GroupeQueryFacade {
    List<ListerGroupeEssentielVM> lister();
    ListerGroupeDetailVM recupererGroupeDetailParId(UUID id);
}
