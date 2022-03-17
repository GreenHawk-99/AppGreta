package com.cda.contenu_seance.service;

import com.cda.contenu_seance.model.Coordinateur;
import com.cda.contenu_seance.model.Formateur;
import com.cda.contenu_seance.model.Intervenant;
import com.cda.contenu_seance.repository.IntervenantRepository;
import com.cda.contenu_seance.repository.SessionRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class IntervenantServiceTest {

    @Autowired
    private IntervenantRepository intervenantRepository;

    @Test
    void getFormateurs() {
    }

    @Test
    void getCoordinateur() {
    }

    @Test
    void saveUpdateFormateur() {
    }

    @Test
    void saveUpdateCoordinateur() {
    }

    @Transactional
    @Test
    void deleteIntervenant() {
        intervenantRepository.deleteById(1L);
        assertNull(intervenantRepository.findById(1L));
    }

    @Transactional
    @Test
    void deleteFormateur(){
        intervenantRepository.deleteById(1L);
        assertNull(intervenantRepository.findById(1L));
    }

    @Transactional
    @Test
    void deleteCoordinateur() {
        intervenantRepository.deleteById(1L);
        assertNull(intervenantRepository.findById(1L));
    }
}