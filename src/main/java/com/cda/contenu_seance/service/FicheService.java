package com.cda.contenu_seance.service;

import com.cda.contenu_seance.dto.SeanceDTO;
import com.cda.contenu_seance.model.*;
import com.cda.contenu_seance.repositories.*;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FicheService {
    FormateurRepository formateurRepository;
    SeanceRepository seanceRepository;
    CompetenceRepository competenceRepository;
    ActiviteRepository activiteRepository;
    SessionRepository sessionRepository;
    FormationRepository formationRepository;

    @Autowired
    public FicheService(FormateurRepository formateurRepository,
                        SeanceRepository seanceRepository,
                        CompetenceRepository competenceRepository,
                        ActiviteRepository activiteRepository,
                        SessionRepository sessionRepository,
                        FormationRepository formationRepository){
        this.formateurRepository = formateurRepository;
        this.seanceRepository = seanceRepository;
        this.competenceRepository = competenceRepository;
        this.activiteRepository = activiteRepository;
        this.sessionRepository = sessionRepository;
        this.formationRepository = formationRepository;
    }

    public List<Seance> getFiches(){
        return Lists.newArrayList(seanceRepository.findAll());
    }

    public Seance getFiche(Long id){
        return seanceRepository.findById(id).orElse(new Seance());
    }

    public List<Formation> getFormations(){
        return Lists.newArrayList(formationRepository.findAll());
    }

    public void saveFiche(Seance seance){
        seanceRepository.save(seance);
    }

    public void saveFiche(SeanceDTO seanceDTO){
        Seance seanceDB = seanceRepository.findById(seanceDTO.getId()).orElse(new Seance());
        //Seance seanceDB = getSeance(seanceDTO.getId());
        seanceDB.setDateDuJour(seanceDTO.getDateDuJour());
        seanceDB.setDurer(seanceDTO.getDurer());
        seanceDB.setObjectifPeda(seanceDTO.getObjectifPeda());
        seanceDB.setSupport(seanceDTO.getSupport());
        seanceDB.setDeroulement(seanceDTO.getDeroulement());
    }

    public void deleteFiche(long id){
         seanceRepository.deleteById(id);
    }
}
