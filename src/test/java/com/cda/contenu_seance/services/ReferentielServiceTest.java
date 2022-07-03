package com.cda.contenu_seance.services;

import com.cda.contenu_seance.models.entities.Activite;
import com.cda.contenu_seance.models.entities.Competence;
import com.cda.contenu_seance.models.repositories.CompetenceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReferentielServiceTest {

    @Autowired
    private CompetenceRepository competenceRepository;
    @Autowired
    private ReferentielService referentielService;

    @BeforeEach
    void setup() {
        assertNotNull(referentielService);
    }
    @AfterEach
    void teardown(){

    }

    @Test
    void getAllCompetences() {
        List<Competence> competences = referentielService.getAllCompetences();
        for (Competence uneCompetence: competences){
            assertNotNull(uneCompetence.getCompetenceProfessionel());
            assertNotNull(uneCompetence.getActivite());
        }
    }

    @Test
    void getCompetence() {
        Competence competence = referentielService.getCompetence(1L);
        assertNotNull(competence);
        assertEquals("Maquetter une application", competence.getCompetenceProfessionel());
    }

    @Transactional
    @Test
    void saveCompetenceC() {
        Competence competence = new Competence();
        competence.setCompetenceProfessionel("test save");
        competence.setNumCP(8);
        Activite activite = referentielService.getActivite(1L);
        competence.setActivite(activite);
        assertEquals("test save", competence.getCompetenceProfessionel());
        assertEquals(activite, competence.getActivite());

    }

    @Transactional
    @Test
    void saveCompetenceU() {
        Competence competence = referentielService.getCompetence(2L);
        competence.setCompetenceProfessionel("test edit");
        competence.setNumCP(16);
        competence = referentielService.getCompetence(2L);
        assertEquals("test edit", competence.getCompetenceProfessionel());
    }

    @Test
    void deleteCompetence() {
    }
}