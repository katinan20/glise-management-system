package com.paulo.eglisemanagementsystem.core.common;

import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.exception.NonTrouverGroupe;

/**
 * @author katinan.toure 12/05/2025 23:05
 * @project eglise-management-system
 */
public interface GestionnaireRequetes<P, C>{
    P query(C commande) throws NonTrouverGroupe;
}
