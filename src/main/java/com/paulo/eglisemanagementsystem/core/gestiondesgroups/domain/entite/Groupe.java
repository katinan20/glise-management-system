package com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.entite;

import com.paulo.eglisemanagementsystem.core.common.objetvalue.BasseEntity;
import com.paulo.eglisemanagementsystem.core.gestiondesactivites.domain.entite.Activite;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.objectvalues.MembreGroupe;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 00:07
 * @project eglise-management-system
 */

@Getter
@Setter
public class Groupe extends BasseEntity {
    private UUID id;
    private String nom;
    private String code;
    private String description;
}
