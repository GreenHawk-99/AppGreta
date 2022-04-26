package com.cda.contenu_seance.services;

import com.cda.contenu_seance.models.repositories.IntervenantRepository;
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