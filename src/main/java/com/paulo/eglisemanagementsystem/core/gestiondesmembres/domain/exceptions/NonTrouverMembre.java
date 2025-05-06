package com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.exceptions;

/**
 * @author katinan.toure 03/05/2025 12:31
 * @project eglise-management-system
 */
public class NonTrouverMembre extends RuntimeException {
    private String membre;
    public NonTrouverMembre(String message) {
        super(message);
    }

    public String getMembre() {
        return membre;
    }

    public void setMembre(String membre) {
        this.membre = membre;
    }
}
