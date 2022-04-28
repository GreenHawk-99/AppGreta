package com.cda.contenu_seance.services;

import com.cda.contenu_seance.dto.*;
import com.cda.contenu_seance.models.entities.*;
import com.cda.contenu_seance.models.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FicheService {
    SeanceRepository seanceRepository;
    SessionRepository sessionRepository;
    FormationRepository formationRepository;
    CentreRepository centreRepository;
    EvaluationRepository evaluationRepository;
    SavoirFaireRepository savoirFaireRepository;

    @Autowired
    public FicheService(SeanceRepository seanceRepository,
                        SessionRepository sessionRepository,
                        FormationRepository formationRepository,
                        CentreRepository centreRepository,
                        EvaluationRepository evaluationRepository,
                        SavoirFaireRepository savoirFaireRepository){
        this.centreRepository = centreRepository;
        this.seanceRepository = seanceRepository;
        this.sessionRepository = sessionRepository;
        this.formationRepository = formationRepository;
        this.evaluationRepository = evaluationRepository;
        this.savoirFaireRepository = savoirFaireRepository;
    }

    /*private SeanceDTO convertSeanceEntityToSeanceDTO(Seance seance){
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

    public List<Seance> getAllFiches(){
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
        seanceDb.setObjectifPeda(seanceDTO.getObjectifPeda().trim());
        seanceDb.setMethodeEnvisage(seanceDTO.getMethodeEnvisage().trim());
        seanceDb.setSupport(seanceDTO.getSupport().trim());
        seanceDb.setDeroulement(seanceDTO.getDeroulement().trim());
        seanceDb.setFormateurs(seanceDTO.getFormateur());
        seanceDb.setSession(seanceDTO.getSession());
        seanceDb.setEvaluation(seanceDTO.getEvaluation());
        seanceRepository.save(seanceDb);
    }

    public void deleteFiche(long id){
         seanceRepository.deleteById(id);
    }

    // Méthodes CRUD Formation

    public List<Formation> getAllFormations(){
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
        formationDb.setTypeFormation(formationDTO.getTypeFormation().trim());
        formationRepository.save(formationDb);
    }

    public void deleteFormation(long id){
        formationRepository.deleteById(id);
    }

    // Méthodes CRUD Centre

    public List<Centre> getAllCentres(){
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
            centreDb = getCentre(centreDTO.getId());
            //centreDb = centreRepository.findById(centreDTO.getId()).orElse(new Centre());
        }
        centreDb.setNomCentre(centreDTO.getNomCentre().trim());
        centreDb.setAdresseCentre(centreDTO.getAdresseCentre().trim());
        centreDb.setCodesPostal(centreDTO.getCodesPostal().trim());
        centreDb.setVille(centreDTO.getVille().trim());
        centreRepository.save(centreDb);
    }

    public void deleteCentre(long id){
        centreRepository.deleteById(id);
    }

    // Méthodes CRUD Session

    public List<Session> getAllSessions(){
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
        sessionDb.setDureeTotal(sessionDTO.getDureeTotal());
        sessionDb.setSeances(sessionDTO.getSeances());
        sessionDb.setCentre(sessionDTO.getCentre());
        //TODO
        sessionRepository.save(sessionDb);
    }

    public void deleteSession(long id){
        sessionRepository.deleteById(id);
    }

    // Méthodes CRUD Evaluation

    public List<Evaluation> getAllEvaluations(){
        return evaluationRepository.findAll();
    }

    public void saveEvaluation(EvaluationDTO evaluationDTO){
        Evaluation evaluationDb;
        if (null==evaluationDTO.getId()){
            evaluationDb = new Evaluation();
        } else {
            evaluationDb = evaluationRepository.findById(evaluationDTO.getId()).orElse(new Evaluation());
        }
        evaluationDb.setModalite(evaluationDTO.getModalite());
        evaluationDb.setSeances(evaluationDTO.getSeances());
        evaluationRepository.save(evaluationDb);
    }

    public void deleteEvaluation (long id){
        evaluationRepository.deleteById(id);
    }

    // Méthodes CRUD SavoirFaire

    public List<SavoirFaire> getAllSavoirFaires(){
        return  savoirFaireRepository.findAll();
    }


}
