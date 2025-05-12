package com.paulo.eglisemanagementsystem.factory;

import com.paulo.eglisemanagementsystem.service.repository.JpaMembreRepository;
import com.paulo.eglisemanagementsystem.service.tables.MembreTable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;


/**
 * @author katinan.toure 09/05/2025 21:05
 * @project eglise-management-system
 */

@Component
public class MembreFactory {

    private final JpaMembreRepository jpaMembreRepository;

    public MembreFactory(JpaMembreRepository jpaMembreRepository) {
        this.jpaMembreRepository = jpaMembreRepository;
    }

    public MembreTable creerMembre() {
        MembreTable membre = new MembreTable();
        membre.setId(UUID.randomUUID());
        membre.setNom("SORO");
        membre.setPrenom("JEAN");
        membre.setSexe("FEMME");
        membre.setEmail("jean@gmail.com");
        membre.setTelephone("0969321478");
        membre.setAdresse("Abidjan");
        membre.setDateNaissance(LocalDate.of(1990, 6, 10));
        membre.setDateAdhesion(LocalDate.now());
        membre.setActif(true);
        this.jpaMembreRepository.save(membre);
        return membre;
    }
}
