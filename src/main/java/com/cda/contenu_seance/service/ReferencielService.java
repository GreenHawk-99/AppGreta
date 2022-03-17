package com.cda.contenu_seance.service;

import com.cda.contenu_seance.dto.ActiviteDTO;
import com.cda.contenu_seance.dto.CompetenceDTO;
import com.cda.contenu_seance.model.*;
import com.cda.contenu_seance.repository.*;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class ReferencielService {
    private ActiviteRepository activiteRepository;
    private CompetenceRepository competenceRepository;
    private ReacRepository reacRepository;

    @Autowired
    public ReferencielService(ActiviteRepository activiteRepository,
                              CompetenceRepository competenceRepository,
                              ReacRepository reacRepository){
        this.activiteRepository = activiteRepository;
        this.competenceRepository = competenceRepository;
        this.reacRepository = reacRepository;
    }

    // TODO EntityToDTO
    //  DTOToEntity
    //  saveRef

    public void saveUpdateActivite(ActiviteDTO activiteDTO){
        Activite activite = activiteRepository.findById(activiteDTO.getId()).orElse(new Activite());
        activite.setActivitesTypes(activiteDTO.getActivitesTypes());
        activite.setNumOrdre(activiteDTO.getNumOrdre());
        activite.setCompetences(activiteDTO.getCompetences());
        activite.setReac(activiteDTO.getReac());
    }

    public void saveUpdateCompetence(CompetenceDTO competenceDTO){
        Competence competence = competenceRepository.findById(competenceDTO.getId()).orElse(new Competence());
        competence.setNom(competenceDTO.getNom());
        competence.setActivite(competenceDTO.getActiviter());
        competence.setSeances(competenceDTO.getSeances());
    }

    public List<Activite> getActivites(){
        return Lists.newArrayList(activiteRepository.findAll());
    }

    public List<Competence> getCompetences(){
        return Lists.newArrayList(competenceRepository.findAll());
    }

    public Reac getReac(Long id){
        return reacRepository.findById(id).orElse(new Reac());
    }
}
