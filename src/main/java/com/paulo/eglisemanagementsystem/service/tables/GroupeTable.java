package com.paulo.eglisemanagementsystem.service.tables;

import com.paulo.eglisemanagementsystem.core.gestiondesactivites.domain.entite.Activite;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.domain.objectvalues.MembreGroupe;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 00:39
 * @project eglise-management-system
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "groupe")
public class GroupeTable extends BaseEntityTable {
    @Id
    private UUID id;
    @NotBlank(message = "le nom est obligatoire")
    @Column(nullable = false)
    private String nom;
    @NotBlank(message = "l description est obligatoire")
    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "groupe", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MembreGroupeTable> membres = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "groupe_activite",
            joinColumns = @JoinColumn(name = "groupe_id"),
            inverseJoinColumns = @JoinColumn(name = "activite_id")
    )
    private Set<ActiviteTable> activites = new HashSet<>();
}
