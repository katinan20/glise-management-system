package com.paulo.eglisemanagementsystem.service.tables;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 01:40
 * @project eglise-management-system
 */

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ParticipationActivite")
public class ParticipationActiviteTable {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membre_id", nullable = false)
    private MembreTable membre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activite_id", nullable = false)
    private ActiviteTable activite;

    @Column(length = 100)
    private String role;

    private boolean presence;

}
