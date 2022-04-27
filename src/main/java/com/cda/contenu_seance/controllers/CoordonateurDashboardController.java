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

@Validated
@Controller
@RequestMapping(value = "/coordonateur/dashboard")
public class CoordonateurDashboardController implements WebMvcConfigurer {
    FicheService ficheService;
    IntervenantService intervenantService;
    ReferentielService referentielService;

    @Autowired
    public CoordonateurDashboardController(FicheService ficheService,
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
        return "dashboardCoordonateur/dashboardCentres";
    }

    @GetMapping(value = "/fiches")
    public String dashboardFiches(Model model) {
        // Tableau
        model.addAttribute("fiches", ficheService.getAllFiches());
        // Form
        model.addAttribute("ficheForm", new SeanceDTO());
        model.addAttribute("competences", referentielService.getAllCompetences());
        model.addAttribute("sessions", ficheService.getAllSessions());
        return "dashboardCoordonateur/dashboardFiches";
    }

    @GetMapping(value = "/formateurs")
    public String dashboardFormateurs(Model model) {
        // Tableau
        model.addAttribute("formateurs", intervenantService.getAllFormateurs());
        // Form
        model.addAttribute("formateurForm", new IntervenantDTO());
        return "dashboardCoordonateur/dashboardFormateurs";
    }

    @GetMapping(value = "/formations")
    public String dashboardFormations(Model model) {
        // Tableau
        model.addAttribute("formations", ficheService.getAllFormations());
        // Form
        model.addAttribute("formationForm", new FormationDTO());
        return "dashboardCoordonateur/dashboardFormations";
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
        return "dashboardCoordonateur/dashboardSessions";
    }

    @GetMapping(value = "/activites")
    public String dashboardActivites(Model model) {
        // Tableau
        model.addAttribute("activites", referentielService.getAllActivites());
        // Form
        model.addAttribute("activiteForm", new ActiviteDTO());
        model.addAttribute("reacs", referentielService.getAllReacs());
        return "dashboardCoordonateur/dashboardActivites";
    }

    @GetMapping(value = "/competences")
    public String dashboardCompetences(Model model) {
        // Tableau
        model.addAttribute("competences", referentielService.getAllCompetences());
        // Form
        model.addAttribute("competenceForm", new CompetenceDTO());
        model.addAttribute("activites", referentielService.getAllActivites());
        return "dashboardCoordonateur/dashboardCompetences";
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
        return "dashboardCoordonateur/dashboardReferentiels";
    }

    @GetMapping(value="/evaluation")
    public String dashboardEvaluation(Model model) {
        // Tableau
        model.addAttribute("evaluations", ficheService.getAllEvaluations());
        //Form
        model.addAttribute("evaluationForm", new EvaluationDTO());
        return "dashboardEvaluation";
    }
}
