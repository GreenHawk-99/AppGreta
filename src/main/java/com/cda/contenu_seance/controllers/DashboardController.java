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
@RequestMapping(value = "/dashboard")*/
public class DashboardController implements WebMvcConfigurer {
    FicheService ficheService;
    IntervenantService intervenantService;
    ReferentielService referentielService;

    @Autowired
    public DashboardController(FicheService ficheService,
                               IntervenantService intervenantService,
                               ReferentielService referentielService) {
        this.ficheService = ficheService;
        this.intervenantService = intervenantService;
        this.referentielService = referentielService;
    }

    @GetMapping(value = "/centres")
    public String dashboardCentres(Model model) {
        // Tableau
        model.addAttribute("centres", ficheService.getAllCentres());
        // Form
        model.addAttribute("centreForm", new CentreDTO());
        return "dashboard/dashboardCentres";
    }

    @GetMapping(value = "/fiches")
    public String dashboardFiches(Model model) {
        // Tableau
        model.addAttribute("fiches", ficheService.getAllFiches());
        // Form
        model.addAttribute("ficheForm", new SeanceDTO());
        model.addAttribute("competences", referentielService.getAllCompetences());
        model.addAttribute("sessions", ficheService.getAllSessions());
        return "dashboard/dashboardFiches";
    }

    @GetMapping(value = "/formateurs")
    public String dashboardFormateurs(Model model) {
        // Tableau
        model.addAttribute("formateurs", intervenantService.getAllFormateurs());
        // Form
        model.addAttribute("formateurForm", new IntervenantDTO());
        return "dashboard/dashboardFormateurs";
    }

    @GetMapping(value = "/formations")
    public String dashboardFormations(Model model) {
        // Tableau
        model.addAttribute("formations", ficheService.getAllFormations());
        // Form
        model.addAttribute("formationForm", new FormationDTO());
        return "dashboard/dashboardFormations";
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
        return "dashboard/dashboardSessions";
    }

    @GetMapping(value = "/activites")
    public String dashboardActivites(Model model) {
        // Tableau
        model.addAttribute("activites", referentielService.getAllActivites());
        // Form
        model.addAttribute("activiteForm", new ActiviteDTO());
        model.addAttribute("reacs", referentielService.getAllReacs());
        return "dashboard/dashboardActivites";
    }

    @GetMapping(value = "/competences")
    public String dashboardCompetences(Model model) {
        // Tableau
        model.addAttribute("competences", referentielService.getAllCompetences());
        // Form
        model.addAttribute("competenceForm", new CompetenceDTO());
        model.addAttribute("activites", referentielService.getAllActivites());
        return "dashboard/dashboardCompetences";
    }

    @GetMapping(value = "/referentiels")
    public String dashboardReac(Model model) {
        // Tableau
        model.addAttribute("reacs", referentielService.getAllReacs());
        model.addAttribute("activites", referentielService.getAllActivites());
        model.addAttribute("competences", referentielService.getAllCompetences());
        // Form
        model.addAttribute("reacForm", new ReacDTO());
        model.addAttribute("formations", ficheService.getAllFormations());
        return "dashboard/dashboardReferentiels";
    }
}
