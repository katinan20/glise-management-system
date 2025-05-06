package com.paulo.eglisemanagementsystem.service.interfaces.res;

import com.paulo.eglisemanagementsystem.core.gestiondesmembres.applications.commande.CreerMembresCommande;
import com.paulo.eglisemanagementsystem.factory.TestUtils;
import com.paulo.eglisemanagementsystem.service.repository.JpaMembreRepository;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author katinan.toure 03/05/2025 13:33
 * @project eglise-management-system
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MembreRessourceTest {
    private static final String API_URL = "/membre";

    @Autowired
    MembreRessource membreRessource;

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
        commande.setEmail("paulo@gmail.com");
        commande.setTelephone("0102030405");
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
        mvcResult.andExpect(status().isOk());
    }
}