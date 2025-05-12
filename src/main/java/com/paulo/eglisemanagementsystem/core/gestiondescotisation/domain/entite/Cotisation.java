package com.paulo.eglisemanagementsystem.core.gestiondescotisation.domain.entite;

import com.paulo.eglisemanagementsystem.core.gestiondescotisation.domain.objetvalue.StatutCotisation;
import com.paulo.eglisemanagementsystem.service.tables.MembreTable;
import com.paulo.eglisemanagementsystem.service.tables.TypeCotisationTable;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 00:05
 * @project eglise-management-system
 */

@Getter
@Setter
public class Cotisation {
    private UUID id;
    private MembreTable membre;
    private TypeCotisationTable typeCotisation;
    private LocalDate datePaiement;
    private BigDecimal montant;
    private StatutCotisation statut;
}
