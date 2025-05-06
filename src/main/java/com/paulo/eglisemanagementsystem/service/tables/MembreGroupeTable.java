package com.paulo.eglisemanagementsystem.service.tables;

import com.paulo.eglisemanagementsystem.core.gestiondesgroups.domain.entite.Groupe;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.entite.Membres;
import com.paulo.eglisemanagementsystem.service.util.MembreGroupeId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author katinan.toure 03/05/2025 00:43
 * @project eglise-management-system
 */

@Entity
@IdClass(MembreGroupeId.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "membreGroupe")
public class MembreGroupeTable {

    @Id
    @ManyToOne
    @JoinColumn(name = "membre_id")
    private MembreTable membre;

    @Id
    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private GroupeTable groupe;

    private LocalDate dateAdhesion;

    private String role;

}
