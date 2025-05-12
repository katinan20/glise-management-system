package com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.vm;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 18:00
 * @project eglise-management-system
 */

@Getter
@Setter
public class ListerGroupeEssentielVM {
    private UUID id;
    private String nom;
    private String code;
    private String description;
}
