package com.paulo.eglisemanagementsystem.service.interfaces.res;

import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.commande.CreerGroupeCommande;
import com.paulo.eglisemanagementsystem.core.gestiondesgroups.application.commande.ModifierGroupeCommande;
import com.paulo.eglisemanagementsystem.factory.AbstractTestClasse;
import com.paulo.eglisemanagementsystem.factory.GroupeFactory;
import com.paulo.eglisemanagementsystem.factory.TestUtils;
import com.paulo.eglisemanagementsystem.service.tables.MembreTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author katinan.toure 12/05/2025 15:40
 * @project eglise-management-system
 */
class GroupeRessourceTest extends AbstractTestClasse {
    private static final String API_URL = "/groupe";
    @Autowired
    GroupeRessource groupeRessource;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    GroupeFactory groupeFactory;
    @Autowired
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(groupeRessource)
                .setMessageConverters(mappingJackson2HttpMessageConverter).build();
    }

    @Test
    @DisplayName("Test de creation d'un groupe")
    void creerGroup() throws Exception {
        //given
        var commande = new CreerGroupeCommande();
        commande.setNom("Groupe Musical");
        commande.setCode("GM");
        commande.setDescription("le groupe musical est le groupe qui loue et adore le Seigneur par des chants et instrument");

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
    @DisplayName("Test de modification d'un groupe")
    void modifier() throws Exception {
        var groupe = this.groupeFactory.groupeTable();

        var commande = new ModifierGroupeCommande();
        commande.setId(groupe.getId());
        commande.setNom("Groupe Musical");
        commande.setCode("88L");
        commande.setDescription("description");
        //when
        var mvcResult = this.mockMvc.perform(put(API_URL)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(TestUtils.convertObjectToJsonBytes(commande))
                .contentType(MediaType.APPLICATION_JSON)).andDo(print());
        //then
        mvcResult.andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test de suppression d'un groupe")
    void supprimerGroupe() throws Exception {
        //GIVEN
        var groupe = this.groupeFactory.groupeTable();
        UUID id = groupe.getId();
        var mvcResult = this.mockMvc.perform(delete(API_URL + "/supprimer/{id}", id));
        mvcResult.andExpect(status().isOk());

    }

    @Test
    @DisplayName("Test de listage des groupes")
    void ListeGroupe() throws Exception {
        this.groupeFactory.groupeTable();

        var mvcResult = this.mockMvc.perform(get(API_URL)).andDo(print());

        mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @DisplayName("Test de recuperation d un membres")
    void recupererParIdGoupe() throws Exception {
        var goupeTable =  this.groupeFactory.groupeTable();
        UUID id = goupeTable.getId();

        var mvcResult = this.mockMvc.perform(get(API_URL + "/{id}", id)).andDo(print());

        mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());

    }

}