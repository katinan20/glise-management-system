package com.paulo.eglisemanagementsystem.service.mappers;

import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.vm.ListerGroupeDetailVM;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.vm.ListerGroupeEssentielVM;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.entite.Groupe;
import com.paulo.eglisemanagementsystem.service.tables.GroupeTable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author katinan.toure 12/05/2025 15:19
 * @project eglise-management-system
 */

@Mapper
public abstract class GroupeMappers {
    public final static GroupeMappers INSTANCE = Mappers.getMapper(GroupeMappers.class);
    public abstract GroupeTable groupeVersGroupeTable(Groupe groupe);
    public abstract Groupe groupeTableVersGroupe(GroupeTable groupe);
    public abstract ListerGroupeEssentielVM groupeTableVersGroupeEssentielVM(GroupeTable groupeTable);
    public abstract ListerGroupeDetailVM groupeTableVersGroupeDetailVM(GroupeTable groupeTable);
}
