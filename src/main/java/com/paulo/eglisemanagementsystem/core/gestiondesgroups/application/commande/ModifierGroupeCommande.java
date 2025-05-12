package com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.commande;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 16:20
 * @project eglise-management-system
 */

@Getter
@Setter
public class ModifierGroupeCommande extends CreerGroupeCommande{
    private UUID id;
}
