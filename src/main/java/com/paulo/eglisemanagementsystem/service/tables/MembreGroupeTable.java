package com.paulo.eglisemanagementsystem.service.tables;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 00:43
 * @project eglise-management-system
 */


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "membreGroupe")
public class MembreGroupeTable {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "membre_id")
    private MembreTable membre;


    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private GroupeTable groupe;

    private LocalDate dateAdhesion;

    private String role;

}
