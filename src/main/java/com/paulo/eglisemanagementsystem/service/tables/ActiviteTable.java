package com.paulo.eglisemanagementsystem.service.tables;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 01:48
 * @project eglise-management-system
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Activite")
public class ActiviteTable {

    @Id
    private UUID id;

    @NotBlank(message = "le nom de l'activité est obligatoire")
    private String libelle;

    private String description;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private String lieu;
    private BigDecimal budget;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<GroupeTable> groupes;

}
