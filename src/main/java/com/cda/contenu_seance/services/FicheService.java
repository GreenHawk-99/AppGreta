package com.cda.contenu_seance.services;

import com.cda.contenu_seance.dto.*;
import com.cda.contenu_seance.models.entities.*;
import com.cda.contenu_seance.models.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FicheService {
    SeanceRepository seanceRepository;
    SessionRepository sessionRepository;
    FormationRepository formationRepository;
    CentreRepository centreRepository;
    SavoirFaireRepository savoirFaireRepository;

    @Autowired
    public FicheService(SeanceRepository seanceRepository,
                        SessionRepository sessionRepository,
                        FormationRepository formationRepository,
                        CentreRepository centreRepository,
                        SavoirFaireRepository savoirFaireRepository){
        this.centreRepository = centreRepository;
        this.seanceRepository = seanceRepository;
        this.sessionRepository = sessionRepository;
        this.formationRepository = formationRepository;
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

    public List<Seance> getEmptyFiche(){
        return seanceRepository.seanceEmptyDOMSOrderByDate();
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
        seanceDb.setEvaluation(seanceDTO.getEvaluation().trim());
        seanceDb.setFormateurs(seanceDTO.getFormateur());
        seanceDb.setSession(seanceDTO.getSession());
        seanceRepository.save(seanceDb);
    }

    public void deleteFiche(long id){
         seanceRepository.deleteById(id);
    }

    public Page<Seance> listAllFiches(int pageNum) {
        int pageSize = 10;

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);


        return seanceRepository.findAll(pageable);
    }
    public Page<Seance> findPaginatedFiches(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.seanceRepository.findAll(pageable);
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
        sessionDb.setCentre(sessionDTO.getCentre());
        sessionDb.setCoordinateur(sessionDTO.getCoordinateur());
        sessionDb.setFormation(sessionDTO.getFormation());
        sessionRepository.save(sessionDb);
    }

    public void deleteSession(long id){
        sessionRepository.deleteById(id);
    }

    // Méthodes CRUD SavoirFaire

    public List<SavoirFaire> getAllSavoirFaires(){
        return savoirFaireRepository.findAll();
    }

    public void saveSavoirFaire(SavoirFaireDTO savoirFaireDTO){
        SavoirFaire savoirFaireDb;
        if (null==savoirFaireDTO.getId()){
            savoirFaireDb = new SavoirFaire();
        } else {
            savoirFaireDb = savoirFaireRepository.findById(savoirFaireDTO.getId()).orElse(new SavoirFaire());
        }
        savoirFaireDb.setNom(savoirFaireDTO.getNom());
        savoirFaireDb.setCompetence(savoirFaireDTO.getCompetence());
        savoirFaireDb.setSeances(savoirFaireDTO.getSeances());
        savoirFaireRepository.save(savoirFaireDb);
    }

    public void deleteSavoirFaire(long id){
        savoirFaireRepository.deleteById(id);
    }

}
