package com.paulo.eglisemanagementsystem.service.tables;

import com.paulo.eglisemanagementsystem.core.gestiondescotisation.domain.objetvalue.StatutCotisation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 01:40
 * @project eglise-management-system
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cotisation")
public class CotisationTable {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membre_id", nullable = false)
    private MembreTable membre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_cotisation_id", nullable = false)
    private TypeCotisationTable typeCotisation;

    private LocalDate datePaiement;

    @Column(nullable = false)
    private BigDecimal montant;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutCotisation statut;

}
