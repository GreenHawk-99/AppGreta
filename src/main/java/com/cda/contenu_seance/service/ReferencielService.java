package com.cda.contenu_seance.service;

import com.cda.contenu_seance.dto.SeanceDTO;
import com.cda.contenu_seance.model.*;
import com.cda.contenu_seance.repositories.*;
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
