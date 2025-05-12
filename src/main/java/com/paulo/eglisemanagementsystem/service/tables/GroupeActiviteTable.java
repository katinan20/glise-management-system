package com.paulo.eglisemanagementsystem.service.tables;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author katinan.toure 09/05/2025 15:30
 * @project eglise-management-system
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "groupe_activite")
public class GroupeActiviteTable {

    @Id
    private UUID id;
    private LocalDateTime dateActivite;
    private int nombreActivite;

    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private GroupeTable groupe;

    @ManyToOne
    @JoinColumn(name = "activite_id")
    private ActiviteTable activite;

}
