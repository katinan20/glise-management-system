package com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.gestionnaire;

import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.exception.NonTrouverGroupe;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.exceptions.NonTrouverMembre;

/**
 * @author katinan.toure 03/05/2025 12:27
 * @project eglise-management-system
 */
public interface GestionnaireRequete<R, P>{
    R query(P var) throws NonTrouverGroupe;
}
