package com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.exception;

/**
 * @author katinan.toure 12/05/2025 15:09
 * @project eglise-management-system
 */
public class NonTrouverGroupe extends RuntimeException {
    public NonTrouverGroupe(String message) {
        super(message);
    }
}
