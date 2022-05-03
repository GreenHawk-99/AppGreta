package com.cda.contenu_seance.controllers;

import com.cda.contenu_seance.dto.*;
import com.cda.contenu_seance.services.FicheService;
import com.cda.contenu_seance.services.IntervenantService;
import com.cda.contenu_seance.services.ReferentielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*@Validated
@Controller
@RequestMapping(value = "/formateur/dashboard")*/
public class FormateurDashboardController implements WebMvcConfigurer {
    FicheService ficheService;
    IntervenantService intervenantService;
    ReferentielService referentielService;

    @Autowired
    public FormateurDashboardController(FicheService ficheService,
                                        IntervenantService intervenantService,
                                        ReferentielService referentielService) {
        this.ficheService = ficheService;
        this.intervenantService = intervenantService;
        this.referentielService = referentielService;
    }



    @GetMapping(value = "/fiches")
    public String dashboardFiches(Model model) {
        // Tableau
        model.addAttribute("fiches", ficheService.getAllFiches());
        // Form
        model.addAttribute("ficheForm", new SeanceDTO());
        model.addAttribute("competences", referentielService.getAllCompetences());
        model.addAttribute("sessions", ficheService.getAllSessions());
        return "dashboardFormateur/dashboardFiches";
    }


    @GetMapping(value = "/formations")
    public String dashboardFormations(Model model) {
        // Tableau
        model.addAttribute("formations", ficheService.getAllFormations());
        // Form
        model.addAttribute("formationForm", new FormationDTO());
        return "dashboardFormateur/dashboardFormations";
    }

    @GetMapping(value = "/sessions")
    public String dashboardSessions(Model model) {
        // Tableau
        model.addAttribute("sessionsGRETA", ficheService.getAllSessions());
        model.addAttribute("formations", ficheService.getAllFormations());
        model.addAttribute("centres", ficheService.getAllCentres());
        model.addAttribute("coordinateurs", intervenantService.getAllCoordinateurs());
        model.addAttribute("formateurs", intervenantService.getAllFormateurs());
        // Form
        model.addAttribute("sessionForm", new SessionDTO());
        return "dashboardFormateur/dashboardSessions";
    }
}
