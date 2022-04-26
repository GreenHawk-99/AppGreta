package com.cda.contenu_seance.services;

import com.cda.contenu_seance.dto.ActiviteDTO;
import com.cda.contenu_seance.dto.CompetenceDTO;
import com.cda.contenu_seance.dto.ReacDTO;
import com.cda.contenu_seance.models.*;
import com.cda.contenu_seance.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferentielService {
    ActiviteRepository activiteRepository;
    CompetenceRepository competenceRepository;
    ReacRepository reacRepository;

    @Autowired
    public ReferentielService(ActiviteRepository activiteRepository,
                              CompetenceRepository competenceRepository,
                              ReacRepository reacRepository) {
        this.activiteRepository = activiteRepository;
        this.competenceRepository = competenceRepository;
        this.reacRepository = reacRepository;
    }

    // Méthodes CRUD Activite

    public List<Activite> getActivites() {
        return activiteRepository.findAll();
    }

    public Activite getActivite(long id) {
        return activiteRepository.findById(id).orElse(null);
    }

    public void saveActivite(ActiviteDTO activiteDTO) {
        Activite activiteDb;
        if (null == activiteDTO.getId()) {
            activiteDb = new Activite();
        } else {
            activiteDb = activiteRepository.findById(activiteDTO.getId()).orElse(new Activite());
        }
        activiteDb.setActivitesTypes(activiteDTO.getActivitesTypes().trim());
        activiteDb.setNumAT(activiteDTO.getNumAT());
        activiteDb.setReac(activiteDTO.getReac());
        activiteRepository.save(activiteDb);
    }

/*
    public void updateActivite(ActiviteDTO activiteDTO) {
        Activite activiteDb = activiteRepository.findById(activiteDTO.getId()).orElse(null);
        activiteDb.setActivitesTypes(activiteDTO.getActivitesTypes());
        activiteDb.setNumAT(activiteDTO.getNumAT());
        activiteDb.setReac(activiteDTO.getReac());
        activiteRepository.save(activiteDb);
    }
*/

    public void deleteActivite(long id) {
        activiteRepository.deleteById(id);
    }

    // Méthodes CRUD Competence

    public List<Competence> getCompetences() {
        return competenceRepository.findAll();
    }

    public Competence getCompetence(long id) {
        return competenceRepository.findById(id).orElse(null);
    }

    public void saveCompetence(CompetenceDTO competenceDTO) {
        Competence competenceDb;
        if (null == competenceDTO.getId()) {
            competenceDb = new Competence();
        } else {
            competenceDb = competenceRepository.findById(competenceDTO.getId()).orElse(new Competence());
        }
        competenceDb.setCompetenceProfessionel(competenceDTO.getCompetenceProfessionel().trim());
        competenceDb.setNumCP(competenceDTO.getNumCP());
        competenceDb.setActivite(competenceDTO.getActivite());
        competenceRepository.save(competenceDb);
    }

    public void deleteCompetence(long id) {
        competenceRepository.deleteById(id);
    }

    // Méthodes CRUD Reac

    public List<Reac> getReacs() {
        return reacRepository.findAll();
    }

    public Reac getReac(long id) {
        return reacRepository.findById(id).orElse(null);
    }

    public void saveReac(ReacDTO reacDTO) {
        Reac reacDb;
        if (null == reacDTO.getId()) {
            reacDb = new Reac();
        } else {
            reacDb = reacRepository.findById(reacDTO.getId()).orElse(new Reac());
        }
        reacDb.setNom(reacDTO.getNom().trim());
        reacDb.setLien(reacDTO.getLien().trim());
        reacDb.setDateDebut(reacDTO.getDateDebut());
        reacDb.setDuree(reacDTO.getDuree());
        reacDb.setFormation(reacDTO.getFormation());
        reacRepository.save(reacDb);
    }

    public void deleteReac(long id) {
        reacRepository.deleteById(id);
    }
}
