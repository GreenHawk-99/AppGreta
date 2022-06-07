package com.cda.contenu_seance.services;

import com.cda.contenu_seance.models.entities.Competence;
import com.cda.contenu_seance.models.repositories.CompetenceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReferentielServiceTest {

    @Autowired
    private CompetenceRepository competenceRepository;

    @Test
    void getAllCompetences() {
    }

    @Test
    void getCompetence() {
        competenceRepository.findById(10L);
    }

    @Test
    void saveCompetence() {

    }

    @Test
    void deleteCompetence() {
    }
}