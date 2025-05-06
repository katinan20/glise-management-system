package com.paulo.eglisemanagementsystem.service.mappers;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite.Membres;
import com.paulo.eglisemanagementsystem.service.tables.MembreTable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author katinan.toure 03/05/2025 12:49
 * @project eglise-management-system
 */

@Mapper
public abstract class MembreMappers {

    public final static MembreMappers INSTANCE = Mappers.getMapper(MembreMappers.class);

    public abstract MembreTable membreCommandeVersMembreTable(Membres membre);
}