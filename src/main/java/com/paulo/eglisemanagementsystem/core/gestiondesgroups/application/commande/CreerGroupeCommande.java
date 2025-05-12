package com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.commande;

import lombok.Getter;
import lombok.Setter;

/**
 * @author katinan.toure 12/05/2025 14:48
 * @project eglise-management-system
 */

@Getter
@Setter
public class CreerGroupeCommande {
    private String nom;
    private String code;
    private String description;
}
