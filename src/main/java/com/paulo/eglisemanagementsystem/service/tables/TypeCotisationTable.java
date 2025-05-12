package com.paulo.eglisemanagementsystem.service.tables;

import com.paulo.eglisemanagementsystem.core.gestiondescotisation.domain.objetvalue.Periodes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 02:21
 * @project eglise-management-system
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TypeCotisation")
public class TypeCotisationTable {
    @Id
    private UUID id;
    private String libelle;
    private Periodes period;
    private BigDecimal montant_suggere;
    private String description;

}
