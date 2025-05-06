package com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.ports;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite.Membres;

/**
 * @author katinan.toure 03/05/2025 11:56
 * @project eglise-management-system
 */
public interface MembreRepositoryPort {
    boolean findByTelephone(String telephone);

    boolean findByEmail(String email);

    void enregistrer(Membres membres);
}
