package com.paulo.eglisemanagementsystem.service.interfaces.res;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.commande.CreerMembresCommande;
import com.paulo.eglisemanagementsystem.service.interfaces.facade.MembreUseCaseFacade;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author katinan.toure 03/05/2025 13:15
 * @project eglise-management-system
 */

@RestController
@RequestMapping("/membre")
public class MembreRessource {

    private final MembreUseCaseFacade membreUseCaseFacade;

    public MembreRessource(MembreUseCaseFacade membreUseCaseFacade) {
        this.membreUseCaseFacade = membreUseCaseFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void creer(@Valid @RequestBody CreerMembresCommande commande){
        this.membreUseCaseFacade.creer(commande);
    }
}
