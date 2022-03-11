package com.cda.contenu_seance.service;

import com.cda.contenu_seance.model.Coordinateur;
import com.cda.contenu_seance.model.Formateur;
import com.cda.contenu_seance.repositories.*;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IntervenantService {
    FormateurRepository formateurRepository;
    CoordinateurRepository coordinateurRepository;

    @Autowired
    public IntervenantService(FormateurRepository formateurRepository,
                        CoordinateurRepository coordinateurRepository){
        this.formateurRepository = formateurRepository;
        this.coordinateurRepository = coordinateurRepository;
    }


    public List<Formateur> getFormateurs(){
        return Lists.newArrayList(formateurRepository.findAll());
    }

    public List<Coordinateur> getCoordinateur(){
        return Lists.newArrayList(coordinateurRepository.findAll());
    }
}
