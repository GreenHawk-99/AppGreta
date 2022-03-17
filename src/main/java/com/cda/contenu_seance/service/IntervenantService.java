package com.cda.contenu_seance.service;

import com.cda.contenu_seance.dto.IntervenantDTO;
import com.cda.contenu_seance.model.Coordinateur;
import com.cda.contenu_seance.model.Formateur;
import com.cda.contenu_seance.model.Intervenant;
import com.cda.contenu_seance.repository.*;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IntervenantService {
    private FormateurRepository formateurRepository;
    private CoordinateurRepository coordinateurRepository;
    private IntervenantRepository intervenantRepository;

    @Autowired
    public IntervenantService(FormateurRepository formateurRepository,
                              CoordinateurRepository coordinateurRepository,
                              IntervenantRepository intervenantRepository){
        this.formateurRepository = formateurRepository;
        this.coordinateurRepository = coordinateurRepository;
        this.intervenantRepository = intervenantRepository;
    }

    private IntervenantDTO convertIEtoIDTO(Intervenant intervenant){
        IntervenantDTO intervenantDTO = new IntervenantDTO();
        intervenantDTO.setId(intervenant.getId());
        intervenantDTO.setNom(intervenant.getNom());
        intervenantDTO.setPrenom(intervenant.getPrenom());
        intervenantDTO.setEmail(intervenant.getEmail());
        intervenantDTO.setMp(intervenant.getMp());
        intervenantDTO.setCodePostal(intervenant.getCodePostal());
        intervenantDTO.setTel(intervenant.getTel());
        return intervenantDTO;
    }

    /*
    private Intervenant convertIDTOtoIE(IntervenantDTO intervenantDTO){
        Intervenant intervenant = new Intervenant();
        intervenant.setId(intervenantDTO.getId());
        intervenant.setNom(intervenantDTO.getNom());
        intervenant.setPrenom(intervenantDTO.getPrenom());
        intervenant.setEmail(intervenantDTO.getEmail());
        intervenant.setMp(intervenantDTO.getMp());
        intervenant.setCodePostal(intervenantDTO.getCodePostal());
        intervenant.setTel(intervenantDTO.getTel());
        return intervenant;
    }
    */

    public List<Formateur> getFormateurs(){
        return Lists.newArrayList(formateurRepository.findAll());
    }

    public List<Coordinateur> getCoordinateur(){
        return Lists.newArrayList(coordinateurRepository.findAll());
    }

    public void saveUpdateFormateur(IntervenantDTO intervenantDTO){
        /*if (intervenantDTO == null){

        }*/
        Intervenant intervenant = intervenantRepository.findById(intervenantDTO.getId()).orElse(new Formateur());
        intervenant.setNom(intervenantDTO.getNom());
        intervenant.setPrenom(intervenantDTO.getPrenom());
        intervenant.setEmail(intervenantDTO.getEmail());
        intervenant.setMp(intervenantDTO.getMp());
        intervenant.setCodePostal(intervenantDTO.getCodePostal());
        intervenant.setTel(intervenantDTO.getTel());
    }

    public void saveUpdateCoordinateur(IntervenantDTO intervenantDTO){
        Intervenant intervenant = intervenantRepository.findById(intervenantDTO.getId()).orElse(new Coordinateur());
        intervenant.setNom(intervenantDTO.getNom());
        intervenant.setPrenom(intervenantDTO.getPrenom());
        intervenant.setEmail(intervenantDTO.getEmail());
        intervenant.setMp(intervenantDTO.getMp());
        intervenant.setCodePostal(intervenantDTO.getCodePostal());
        intervenant.setTel(intervenantDTO.getTel());
    }

    public void deleteIntervenant(Long id){
        intervenantRepository.deleteById(id);
    }

    public void deleteFormateur(Long id){
        formateurRepository.deleteById(id);
    }

    public void deleteCoordinateur(Long id){
        coordinateurRepository.deleteById(id);
    }
}
