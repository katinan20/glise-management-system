package com.paulo.eglisemanagementsystem.core.common;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite.Membres;

/**
 * @author katinan.toure 03/05/2025 12:27
 * @project eglise-management-system
 */
public interface GestionnaireCommande<P,C> {
    P executer(C vars);
}
