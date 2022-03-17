package com.cda.contenu_seance.service;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.dto.SeanceDTO;
import com.cda.contenu_seance.model.*;
import com.cda.contenu_seance.repository.*;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FicheService {
    private FormateurRepository formateurRepository;
    private SeanceRepository seanceRepository;
    private SessionRepository sessionRepository;
    private FormationRepository formationRepository;
    private CentreRepository centreRepository;

    @Autowired
    public FicheService(FormateurRepository formateurRepository,
                        SeanceRepository seanceRepository,
                        SessionRepository sessionRepository,
                        FormationRepository formationRepository,
                        CentreRepository centreRepository){
        this.centreRepository = centreRepository;
        this.formateurRepository = formateurRepository;
        this.seanceRepository = seanceRepository;
        this.sessionRepository = sessionRepository;
        this.formationRepository = formationRepository;
    }

    private SeanceDTO convertSEtoSDTO(Seance seance){
        SeanceDTO seanceDTO = new SeanceDTO();
        seanceDTO.setId(seance.getId());
        seanceDTO.setDateDuJour(seance.getDateDuJour());
        seanceDTO.setDurer(seance.getDurer());
        seanceDTO.setObjectifPeda(seance.getObjectifPeda());
        seanceDTO.setSupport(seance.getSupport());
        seanceDTO.setDeroulement(seance.getDeroulement());
        seanceDTO.setFormateur(seance.getFormateurs());
        seanceDTO.setSession(seance.getSession());
        return seanceDTO;
    }
    private Seance convertSDTOtoSE(SeanceDTO seanceDTO){
        Seance seance = new Seance();
        seance.setId(seanceDTO.getId());
        seance.setDateDuJour(seanceDTO.getDateDuJour());
        seance.setDurer(seanceDTO.getDurer());
        seance.setObjectifPeda(seanceDTO.getObjectifPeda());
        seance.setSupport(seanceDTO.getSupport());
        seance.setDeroulement(seanceDTO.getDeroulement());
        seance.setFormateurs(seanceDTO.getFormateur());
        seance.setSession(seanceDTO.getSession());
        return seance;
    }

    public List<Seance> getFiches(){
        return Lists.newArrayList(seanceRepository.findAll());
    }

    public Seance getFiche(Long id){
        return seanceRepository.findById(id).orElse(new Seance());
    }

    public void saveUpdateFiche(Seance seance){
        seanceRepository.save(seance);
    }

    public void saveUpdateFiche(SeanceDTO seanceDTO){
        Seance seanceDb = seanceRepository.findById(seanceDTO.getId()).orElse(new Seance());
        //Seance seance = getSeance(seanceDTO.getId());
        seanceDb.setDateDuJour(seanceDTO.getDateDuJour());
        seanceDb.setDurer(seanceDTO.getDurer());
        seanceDb.setObjectifPeda(seanceDTO.getObjectifPeda());
        seanceDb.setSupport(seanceDTO.getSupport());
        seanceDb.setDeroulement(seanceDTO.getDeroulement());
    }

    public void deleteFiche(Long id){
         seanceRepository.deleteById(id);
    }

    public List<Formation> getFormations(){
        return Lists.newArrayList(formationRepository.findAll());
    }

    public List<Centre> getCentres(){
        return centreRepository.findAll();
    }

    public void saveUpdateCentre(CentreDTO centreDTO){
        Centre centreDb = centreRepository.findById(centreDTO.getId()).orElse(new Centre());
        centreDb.setNomCentre(centreDTO.getNomCentre());
        centreDb.setAdresseCentre(centreDTO.getAdresseCentre());
        centreDb.setCodesPostal(centreDTO.getCodesPostal());
        centreDb.setVille(centreDTO.getVille());
    }

    public void deleteCentre(Long id){

    }
}
