package com.cda.contenu_seance.service;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.dto.FormationDTO;
import com.cda.contenu_seance.dto.SeanceDTO;
import com.cda.contenu_seance.dto.SessionDTO;
import com.cda.contenu_seance.model.*;
import com.cda.contenu_seance.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FicheService {
    SeanceRepository seanceRepository;
    SessionRepository sessionRepository;
    FormationRepository formationRepository;
    CentreRepository centreRepository;

    @Autowired
    public FicheService(SeanceRepository seanceRepository,
                        SessionRepository sessionRepository,
                        FormationRepository formationRepository,
                        CentreRepository centreRepository){
        this.centreRepository = centreRepository;
        this.seanceRepository = seanceRepository;
        this.sessionRepository = sessionRepository;
        this.formationRepository = formationRepository;
    }

    /*private SeanceDTO convertSEtoSDTO(Seance seance){
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
    }*/

    // Méthodes CRUD Fiche

    public List<Seance> getFiches(){
        return seanceRepository.findAll();
    }

    public Seance getFiche(long id){
        return seanceRepository.findById(id).orElse(new Seance());
    }

    public void saveFiche(SeanceDTO seanceDTO){
        Seance seanceDb;
        if (null==seanceDTO.getId()) {
            seanceDb = new Seance();
        } else {
            seanceDb = seanceRepository.findById(seanceDTO.getId()).orElse(new Seance());
        }
        seanceDb.setDateDuJour(seanceDTO.getDateDuJour());
        seanceDb.setDuree(seanceDTO.getDuree());
        seanceDb.setObjectifPeda(seanceDTO.getObjectifPeda());
        seanceDb.setSupport(seanceDTO.getSupport());
        seanceDb.setDeroulement(seanceDTO.getDeroulement());
        seanceDb.setFormateurs(seanceDTO.getFormateur());
        seanceDb.setSession(seanceDTO.getSession());
        seanceRepository.save(seanceDb);
    }

    public void updateFiche(SeanceDTO seanceDTO){
        Seance seanceDb = seanceRepository.findById(seanceDTO.getId()).orElse(new Seance());
        seanceDb.setDateDuJour(seanceDTO.getDateDuJour());
        seanceDb.setDuree(seanceDTO.getDuree());
        seanceDb.setObjectifPeda(seanceDTO.getObjectifPeda());
        seanceDb.setSupport(seanceDTO.getSupport());
        seanceDb.setDeroulement(seanceDTO.getDeroulement());
        seanceDb.setFormateurs(seanceDTO.getFormateur());
        seanceDb.setSession(seanceDTO.getSession());
        seanceRepository.save(seanceDb);
    }

    public void deleteFiche(long id){
         seanceRepository.deleteById(id);
    }

    // Méthodes CRUD Formation

    public List<Formation> getFormations(){
        return formationRepository.findAll();
    }

    public Formation getFormation(long id){
        return formationRepository.findById(id).orElse(null);
    }

    public void saveFormation(FormationDTO formationDTO){
        Formation formationDb;
        if (null==formationDTO.getId()){
            formationDb = new Formation();
        } else {
            formationDb = formationRepository.findById(formationDTO.getId()).orElse(new Formation());
        }
        formationDb.setTypeFormation(formationDTO.getTypeFormation());
        formationRepository.save(formationDb);
    }

    public void updateFormation(FormationDTO formationDTO){
        Formation formationDb = formationRepository.findById(formationDTO.getId()).orElse(null);
        formationDb.setTypeFormation(formationDTO.getTypeFormation());
        formationRepository.save(formationDb);
    }

    public void deleteFormation(long id){
        formationRepository.deleteById(id);
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
