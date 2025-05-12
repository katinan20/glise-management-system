package com.paulo.eglisemanagementsystem.core.gestiondesactivites.domain.entite;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 00:32
 * @project eglise-management-system
 */

@Getter
@Setter
public class Activite {
    private UUID id;
    private String libelle;
    private String description;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private String lieu;
    private BigDecimal budget;
}
