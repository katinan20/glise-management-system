package com.paulo.eglisemanagementsystem.service.interfaces.res;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.commande.CreerMembresCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.commande.ModifierMembreCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.vm.MembreDetailVM;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.vm.MembreEssentielVM;
import com.paulo.eglisemanagementsystem.service.interfaces.facade.MembreUseCaseFacade;
import com.paulo.eglisemanagementsystem.service.interfaces.facade.query.MembreQueryFacade;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author katinan.toure 03/05/2025 13:15
 * @project eglise-management-system
 */

@RestController
@RequestMapping("/membre")
public class MembreRessource {

    private final MembreUseCaseFacade membreUseCaseFacade;
    private final MembreQueryFacade membreQueryFacade;

    public MembreRessource(MembreUseCaseFacade membreUseCaseFacade, MembreQueryFacade membreQueryFacade) {
        this.membreUseCaseFacade = membreUseCaseFacade;
        this.membreQueryFacade = membreQueryFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void creer(@Valid @RequestBody CreerMembresCommande commande){
        this.membreUseCaseFacade.creer(commande);
    }

    @PutMapping
    public void modifier(@Valid @RequestBody ModifierMembreCommande commande){
        this.membreUseCaseFacade.modiffier(commande);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable("id") UUID id){
        this.membreUseCaseFacade.supprimer(id);
    }

    @GetMapping
    public ResponseEntity<List<MembreEssentielVM>> lister(){
        List<MembreEssentielVM> lister = this.membreQueryFacade.lister();
        return new ResponseEntity<>(lister, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembreDetailVM> recupererParId(@PathVariable("id") UUID id){
        MembreDetailVM membreDetailVM = this.membreQueryFacade.recupererParId(id);
        return new ResponseEntity<>(membreDetailVM, HttpStatus.OK);
    }
}
