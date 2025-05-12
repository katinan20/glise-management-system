package com.paulo.eglisemanagementsystem.service.interfaces.res;

import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.commande.CreerGroupeCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.commande.ModifierGroupeCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.vm.ListerGroupeDetailVM;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.vm.ListerGroupeEssentielVM;
import com.paulo.eglisemanagementsystem.service.interfaces.facade.GroupeUseCaseFacade;
import com.paulo.eglisemanagementsystem.service.interfaces.facade.query.GroupeQueryFacade;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author katinan.toure 12/05/2025 15:34
 * @project eglise-management-system
 */
@RestController
@RequestMapping("/groupe")
public class GroupeRessource {

    private final GroupeUseCaseFacade groupeUseCaseFacade;
    private final GroupeQueryFacade groupeQueryFacade;

    public GroupeRessource(GroupeUseCaseFacade groupeUseCaseFacade, GroupeQueryFacade groupeQueryFacade) {
        this.groupeUseCaseFacade = groupeUseCaseFacade;
        this.groupeQueryFacade = groupeQueryFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void creer(@Valid @RequestBody CreerGroupeCommande commande) {
        this.groupeUseCaseFacade.creer(commande);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void modifier(@Valid @RequestBody ModifierGroupeCommande commande) {
        this.groupeUseCaseFacade.modifier(commande);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable("id") UUID id) {
        this.groupeUseCaseFacade.supprimer(id);
    }

    @GetMapping
    public ResponseEntity<List<ListerGroupeEssentielVM>> lister() {
        List<ListerGroupeEssentielVM> lister = this.groupeQueryFacade.lister();
        return new ResponseEntity<>(lister, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListerGroupeDetailVM> recupererParId(@PathVariable("id") UUID id) {
        ListerGroupeDetailVM groupeDetailVM = this.groupeQueryFacade.recupererGroupeDetailParId(id);
        return new ResponseEntity<>(groupeDetailVM, HttpStatus.OK);
    }

}
