package com.paulo.eglisemanagementsystem.service.util;

import java.util.Objects;
import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 01:28
 * @project eglise-management-system
 */
public class MembreGroupeId {
    private UUID membre;
    private UUID groupe;

    public MembreGroupeId() {}

    public MembreGroupeId(UUID membre, UUID groupe) {
        this.membre = membre;
        this.groupe = groupe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MembreGroupeId)) return false;
        MembreGroupeId that = (MembreGroupeId) o;
        return Objects.equals(membre, that.membre) &&
                Objects.equals(groupe, that.groupe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(membre, groupe);
    }
}
