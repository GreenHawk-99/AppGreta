package com.cda.contenu_seance.service;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.dto.SeanceDTO;
import com.cda.contenu_seance.dto.SessionDTO;
import com.cda.contenu_seance.model.*;
import com.cda.contenu_seance.repository.*;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FicheService {
    FormateurRepository formateurRepository;
    SeanceRepository seanceRepository;
    SessionRepository sessionRepository;
    FormationRepository formationRepository;
    CentreRepository centreRepository;

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

    // Méthodes CRUD Fiche

    public List<Seance> getFiches(){
        return Lists.newArrayList(seanceRepository.findAll());
    }

    public Seance getFiche(Long id){
        return seanceRepository.findById(id).orElse(new Seance());
    }

    public void saveUpdateFiche(Seance seance){
        seanceRepository.save(seance);
    }

    public void saveFiche(SeanceDTO seanceDTO){
        Seance seanceDb;
        if (null==seanceDTO.getId()) {
            seanceDb = new Seance();
        } else {
            seanceDb = seanceRepository.findById(seanceDTO.getId()).orElse(new Seance());
        }
        seanceDb.setDateDuJour(seanceDTO.getDateDuJour());
        seanceDb.setDurer(seanceDTO.getDurer());
        seanceDb.setObjectifPeda(seanceDTO.getObjectifPeda());
        seanceDb.setSupport(seanceDTO.getSupport());
        seanceDb.setDeroulement(seanceDTO.getDeroulement());
        seanceRepository.save(seanceDb);
    }

    public void updateFiche(SeanceDTO seanceDTO){
        Seance seanceDb = seanceRepository.findById(seanceDTO.getId()).orElse(new Seance());
        seanceDb.setDateDuJour(seanceDTO.getDateDuJour());
        seanceDb.setDurer(seanceDTO.getDurer());
        seanceDb.setObjectifPeda(seanceDTO.getObjectifPeda());
        seanceDb.setSupport(seanceDTO.getSupport());
        seanceDb.setDeroulement(seanceDTO.getDeroulement());
        seanceRepository.save(seanceDb);
    }

    public void deleteFiche(Long id){
         seanceRepository.deleteById(id);
    }

    // Méthodes CRUD Formation

    public List<Formation> getFormations(){
        return Lists.newArrayList(formationRepository.findAll());
    }

    // Méthodes CRUD Centre

    public List<Centre> getCentres(){
        return centreRepository.findAll();
    }

    public Centre getCentre(long id){
       return centreRepository.findById(id).orElse(null);
    }

    public void saveCentre(CentreDTO centreDTO){
        Centre centreDb;
        if (null==centreDTO.getId()){
            centreDb = new Centre();
        } else{
            centreDb = centreRepository.findById(centreDTO.getId()).orElse(new Centre());
        }
        centreDb.setNomCentre(centreDTO.getNomCentre());
        centreDb.setAdresseCentre(centreDTO.getAdresseCentre());
        centreDb.setCodesPostal(centreDTO.getCodesPostal());
        centreDb.setVille(centreDTO.getVille());
        centreRepository.save(centreDb);
    }

    public void updateCentre(CentreDTO centreDTO){
        Centre centreDb = centreRepository.findById(centreDTO.getId()).orElse(null);
        centreDb.setNomCentre(centreDTO.getNomCentre());
        centreDb.setAdresseCentre(centreDTO.getAdresseCentre());
        centreDb.setCodesPostal(centreDTO.getCodesPostal());
        centreDb.setVille(centreDTO.getVille());
        centreRepository.save(centreDb);
    }

    public void deleteCentre(long id){
        centreRepository.deleteById(id);
    }

    // Méthodes CRUD Session

    public List<Session> getSessions(){
        return sessionRepository.findAll();
    }

    public void saveSession(SessionDTO sessionDTO){
        Session sessionDb;
        if (null==sessionDTO.getId()){
            sessionDb = new Session();
        } else{
            sessionDb = sessionRepository.findById(sessionDTO.getId()).orElse(new Session());
        }
        sessionDb.setDateDebut(sessionDTO.getDateDebut());
        sessionDb.setDateFin(sessionDTO.getDateFin());
        sessionRepository.save(sessionDb);
    }

    public void updateSession(SessionDTO sessionDTO){
        Session sessionDb = sessionRepository.findById(sessionDTO.getId()).orElse(new Session());
        sessionDb.setDateDebut(sessionDTO.getDateDebut());
        sessionDb.setDateFin(sessionDTO.getDateFin());
        sessionRepository.save(sessionDb);
    }

    public void deleteSession(long id){
        sessionRepository.deleteById(id);
    }
}
