package com.cda.contenu_seance.service;

import com.cda.contenu_seance.dto.IntervenantDTO;
import com.cda.contenu_seance.model.Coordinateur;
import com.cda.contenu_seance.model.Intervenant;
import com.cda.contenu_seance.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinateurService {
    CoordinateurRepository coordinateurRepository;
    IntervenantRepository intervenantRepository;

    @Autowired
    public CoordinateurService(CoordinateurRepository coordinateurRepository,
                               IntervenantRepository intervenantRepository) {
        this.coordinateurRepository = coordinateurRepository;
        this.intervenantRepository = intervenantRepository;
    }

    // Méthodes CRUD Coordinateur

    public List<Coordinateur> getCoordinateur() {
        return coordinateurRepository.findAll();
    }

    public Coordinateur getCoordinateur(long id) {
        return coordinateurRepository.findById(id).orElse(null);
    }

    public void saveCoordinateur(IntervenantDTO intervenantDTO) {
        Intervenant intervenantDb;
        if (null == intervenantDTO.getId()) {
            intervenantDb = new Coordinateur();
        } else {
            intervenantDb = intervenantRepository.findById(intervenantDTO.getId()).orElse(new Coordinateur());
        }
        intervenantDb.setNom(intervenantDTO.getNom());
        intervenantDb.setPrenom(intervenantDTO.getPrenom());
        intervenantDb.setEmail(intervenantDTO.getEmail());
        intervenantDb.setMp(intervenantDTO.getMp());
        intervenantDb.setCodePostal(intervenantDTO.getCodePostal());
        intervenantDb.setTel(intervenantDTO.getTel());
        intervenantRepository.save(intervenantDb);
    }

    public void updateCoordinateur(IntervenantDTO intervenantDTO) {
        Intervenant intervenantDb = intervenantRepository.findById(intervenantDTO.getId()).orElse(null);
        intervenantDb.setNom(intervenantDTO.getNom());
        intervenantDb.setPrenom(intervenantDTO.getPrenom());
        intervenantDb.setEmail(intervenantDTO.getEmail());
        intervenantDb.setMp(intervenantDTO.getMp());
        intervenantDb.setCodePostal(intervenantDTO.getCodePostal());
        intervenantDb.setTel(intervenantDTO.getTel());
        intervenantRepository.save(intervenantDb);
    }

    public void deleteCoordinateur(long id) {
        coordinateurRepository.deleteById(id);
    }
}
