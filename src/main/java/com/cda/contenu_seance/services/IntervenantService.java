package com.cda.contenu_seance.services;

import com.cda.contenu_seance.dto.IntervenantDTO;
import com.cda.contenu_seance.models.entities.Coordinateur;
import com.cda.contenu_seance.models.entities.Formateur;
import com.cda.contenu_seance.models.entities.Intervenant;
import com.cda.contenu_seance.models.repositories.CoordinateurRepository;
import com.cda.contenu_seance.models.repositories.FormateurRepository;
import com.cda.contenu_seance.models.repositories.IntervenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntervenantService {
    CoordinateurRepository coordinateurRepository;
    FormateurRepository formateurRepository;
    IntervenantRepository intervenantRepository;

    @Autowired
    public IntervenantService(CoordinateurRepository coordinateurRepository,
                              FormateurRepository formateurRepository,
                              IntervenantRepository intervenantRepository) {
        this.coordinateurRepository = coordinateurRepository;
        this.formateurRepository = formateurRepository;
        this.intervenantRepository = intervenantRepository;
    }

    private void intervenantMain(IntervenantDTO intervenantDTO,Intervenant intervenantDb){
        intervenantDb.setNom(intervenantDTO.getNom().trim().toUpperCase());
        intervenantDb.setPrenom(intervenantDTO.getPrenom().trim());
        intervenantDb.setEmail(intervenantDTO.getEmail().trim());
        intervenantDb.setMp(intervenantDTO.getMp().trim());
        intervenantDb.setCodePostal(intervenantDTO.getCodePostal().trim());
        intervenantDb.setTel(intervenantDTO.getTel().trim());
    }

    // Méthodes CRUD Coordinateur

    public List<Coordinateur> getAllCoordinateurs() {
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
        /*intervenantDb.setNom(intervenantDTO.getNom().trim().toUpperCase());
        intervenantDb.setPrenom(intervenantDTO.getPrenom().trim());
        intervenantDb.setEmail(intervenantDTO.getEmail().trim());
        intervenantDb.setMp(intervenantDTO.getMp().trim());
        intervenantDb.setCodePostal(intervenantDTO.getCodePostal().trim());
        intervenantDb.setTel(intervenantDTO.getTel().trim());*/
        intervenantMain(intervenantDTO,intervenantDb);
        intervenantRepository.save(intervenantDb);
    }

    public void deleteCoordinateur(long id) {
        coordinateurRepository.deleteById(id);
    }

    // Méthodes CRUD Formateur

    public List<Formateur> getAllFormateurs() {
        return formateurRepository.findAll();
    }

    public Formateur getFormateur(long id) {
        return formateurRepository.findById(id).orElse(null);
    }

    public void saveFormateur(IntervenantDTO intervenantDTO) {
        Intervenant intervenantDb;
        if (null == intervenantDTO.getId()) {
            intervenantDb = new Formateur();
        } else {
            intervenantDb = intervenantRepository.findById(intervenantDTO.getId()).orElse(new Formateur());
        }
        /*intervenantDb.setNom(intervenantDTO.getNom().trim().toUpperCase());
        intervenantDb.setPrenom(intervenantDTO.getPrenom().trim());
        intervenantDb.setEmail(intervenantDTO.getEmail().trim());
        intervenantDb.setMp(intervenantDTO.getMp().trim());
        intervenantDb.setCodePostal(intervenantDTO.getCodePostal().trim());
        intervenantDb.setTel(intervenantDTO.getTel().trim());*/
        intervenantMain(intervenantDTO,intervenantDb);
        intervenantRepository.save(intervenantDb);
    }

    public void deleteFormateur(long id) {
        formateurRepository.deleteById(id);
    }
}
