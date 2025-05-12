package com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.commande;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author katinan.toure 09/05/2025 17:24
 * @project eglise-management-system
 */

@Getter
@Setter
public class ModifierMembreCommande  extends CreerMembresCommande{
    private UUID id;

}
