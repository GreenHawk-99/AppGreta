package com.cda.contenu_seance.service;

import com.cda.contenu_seance.dto.IntervenantDTO;
import com.cda.contenu_seance.model.Formateur;
import com.cda.contenu_seance.model.Intervenant;

import com.cda.contenu_seance.repository.FormateurRepository;
import com.cda.contenu_seance.repository.IntervenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormateurService {
    FormateurRepository formateurRepository;
    IntervenantRepository intervenantRepository;

    @Autowired
    public FormateurService(FormateurRepository formateurRepository,
                            IntervenantRepository intervenantRepository) {
        this.formateurRepository = formateurRepository;
        this.intervenantRepository = intervenantRepository;
    }

    // Méthodes CRUD Formateur

    public List<Formateur> getFormateurs() {
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
        intervenantDb.setNom(intervenantDTO.getNom());
        intervenantDb.setPrenom(intervenantDTO.getPrenom());
        intervenantDb.setEmail(intervenantDTO.getEmail());
        intervenantDb.setMp(intervenantDTO.getMp());
        intervenantDb.setCodePostal(intervenantDTO.getCodePostal());
        intervenantDb.setTel(intervenantDTO.getTel());
        intervenantRepository.save(intervenantDb);
    }

    public void updateFormateur(IntervenantDTO intervenantDTO) {
        Intervenant intervenantDb = intervenantRepository.findById(intervenantDTO.getId()).orElse(null);
        intervenantDb.setNom(intervenantDTO.getNom());
        intervenantDb.setPrenom(intervenantDTO.getPrenom());
        intervenantDb.setEmail(intervenantDTO.getEmail());
        intervenantDb.setMp(intervenantDTO.getMp());
        intervenantDb.setCodePostal(intervenantDTO.getCodePostal());
        intervenantDb.setTel(intervenantDTO.getTel());
        intervenantRepository.save(intervenantDb);
    }

    public void deleteFormateur(long id) {
        formateurRepository.deleteById(id);
    }
}
