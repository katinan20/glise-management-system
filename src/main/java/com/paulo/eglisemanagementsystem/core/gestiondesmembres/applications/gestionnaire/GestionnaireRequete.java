package com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.gestionnaire;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.exceptions.NonTrouverMembre;

/**
 * @author katinan.toure 03/05/2025 12:27
 * @project eglise-management-system
 */
public interface GestionnaireRequete <R, P>{
    R query(P var) throws NonTrouverMembre;
}
