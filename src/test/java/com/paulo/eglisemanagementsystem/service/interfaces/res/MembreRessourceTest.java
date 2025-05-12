package com.paulo.eglisemanagementsystem.service.interfaces.res;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.commande.CreerMembresCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.commande.ModifierMembreCommande;
import com.paulo.eglisemanagementsystem.factory.AbstractTestClasse;
import com.paulo.eglisemanagementsystem.factory.MembreFactory;
import com.paulo.eglisemanagementsystem.factory.TestUtils;
import com.paulo.eglisemanagementsystem.service.repository.JpaMembreRepository;
import com.paulo.eglisemanagementsystem.service.tables.MembreTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author katinan.toure 03/05/2025 13:33
 * @project eglise-management-system
 */

class MembreRessourceTest extends AbstractTestClasse {
    private static final String API_URL = "/membre";
    @Autowired
    MembreRessource membreRessource;

    @Autowired
    MembreFactory membreFactory;

    @Autowired
    JpaMembreRepository JpaMembreRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(membreRessource)
                .setMessageConverters(mappingJackson2HttpMessageConverter).build();
    }

    @Test
    @DisplayName("Test de creation d'un membre")
    void createMembre() throws Exception {
        //given
        var commande = new CreerMembresCommande();
        commande.setNom("TOURE");
        commande.setPrenom("PAULO");
        commande.setSexe("HOMME");
        commande.setEmail("pauloddddd@gmail.com");
        commande.setTelephone("0102888030405");
        commande.setAdresse("Abidjan");
        commande.setDateNaissance(LocalDate.of(1998, 7, 27));
        commande.setDateAdhesion(LocalDate.now());
        commande.setActif(true);
        //When
        var mvcResult = this.mockMvc.perform(post(API_URL)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(TestUtils.convertObjectToJsonBytes(commande))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());

        // Then
        mvcResult.andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Test de modification d'un membre")
    void modifier() throws Exception {
       var membres = this.membreFactory.creerMembre();

       var commande = new ModifierMembreCommande();
       commande.setId(membres.getId());
       commande.setNom("TOURE");
       commande.setPrenom("ALICE");
       commande.setSexe(membres.getSexe());
       commande.setEmail(membres.getEmail());
       commande.setTelephone(membres.getTelephone());
       commande.setAdresse(membres.getAdresse());
       commande.setDateNaissance(membres.getDateNaissance());
       commande.setDateAdhesion(membres.getDateAdhesion());
       commande.setActif(true);
        //when
        var mvcResult = this.mockMvc.perform(put(API_URL)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(TestUtils.convertObjectToJsonBytes(commande))
                .contentType(MediaType.APPLICATION_JSON)).andDo(print());
        //then
        mvcResult.andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test de suppression d'un membre")
    void supprimerMembre() throws Exception {
        //GIVEN
        MembreTable membreTable = this.membreFactory.creerMembre();
        UUID id = membreTable.getId();
        var mvcResult = this.mockMvc.perform(delete(API_URL + "/{id}", id));
        mvcResult.andExpect(status().isOk());

    }

    @Test
    @DisplayName("Test de listage des membres")
    void ListeMembre() throws Exception {
        this.membreFactory.creerMembre();

        var mvcResult = this.mockMvc.perform(get(API_URL)).andDo(print());

        mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());

    }
 @Test
    @DisplayName("Test de recuperation d un membres")
    void recupererParIdMembre() throws Exception {
     MembreTable membreTable = this.membreFactory.creerMembre();
     UUID id = membreTable.getId();

     var mvcResult = this.mockMvc.perform(get(API_URL + "/supprimer/{id}", id)).andDo(print());

        mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());

    }

}