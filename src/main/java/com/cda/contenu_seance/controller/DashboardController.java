package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.*;
import com.cda.contenu_seance.service.FicheService;
import com.cda.contenu_seance.service.FormateurService;
import com.cda.contenu_seance.service.ReferentielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController {
    FicheService ficheService;
    FormateurService formateurService;
    ReferentielService referentielService;

    @Autowired
    public DashboardController(FicheService ficheService, FormateurService formateurService, ReferentielService referentielService) {
        this.ficheService = ficheService;
        this.formateurService = formateurService;
        this.referentielService = referentielService;
    }

    @GetMapping(value = "/centres")
    public String dashboardCentres(Model model){
        // Tableau
        model.addAttribute("centres", ficheService.getCentres());
        // Form
        model.addAttribute("centreForm", new CentreDTO());
        return "dashboard/dashboardCentres";
    }

    @GetMapping(value = "/fiches")
    public String dashboardFiches(Model model){
        // Tableau
        model.addAttribute("fiches", ficheService.getFiches());
        // Form
        model.addAttribute("ficheForm", new SeanceDTO());
        model.addAttribute("competences", referentielService.getCompetences());
        model.addAttribute("sessions", ficheService.getSessions());
        return "dashboard/dashboardFiches";
    }

    @GetMapping(value = "/formateurs")
    public String dashboardFormateurs(Model model){
        // Tableau
        model.addAttribute("formateurs", formateurService.getFormateurs());
        // Form
        model.addAttribute("formateurForm", new IntervenantDTO());
        return "dashboard/dashboardFormateurs";
    }

    @GetMapping(value = "/formations")
    public String dashboardFormations(Model model){
        // Tableau
        model.addAttribute("formations", ficheService.getFormations());
        // Form
        model.addAttribute("formationForm", new FormationDTO());
        return "dashboard/dashboardFormations";
    }

    @GetMapping(value = "/sessions")
    public String dashboardSessions(Model model){
        // Tableau
        model.addAttribute("sessionsGRETA", ficheService.getSessions());
        // Form
        model.addAttribute("sessionForm",new SessionDTO());
        return "dashboard/dashboardSessions";
    }

    @GetMapping(value = "/activites")
    public String dashboardActivites(Model model){
        // Tableau
        model.addAttribute("activites", referentielService.getActivites());
        // Form
        model.addAttribute("activiteForm", new ActiviteDTO());
        model.addAttribute("reacs", referentielService.getReacs());
        return "dashboard/dashboardActivites";
    }

    @GetMapping(value = "/competences")
    public String dashboardCompetences(Model model){
        // Tableau
        model.addAttribute("competences", referentielService.getCompetences());
        // Form
        model.addAttribute("competenceForm", new CompetenceDTO());
        model.addAttribute("activites", referentielService.getActivites());
        return "dashboard/dashboardCompetences";
    }

    @GetMapping(value = "/referentiels")
    public String dashboardReac(Model model){
        // Tableau
        model.addAttribute("reacs", referentielService.getReacs());
        model.addAttribute("activites", referentielService.getActivites());
        model.addAttribute("competences", referentielService.getCompetences());
        // Form
        model.addAttribute("reacForm", new ReacDTO());
        model.addAttribute("formations", ficheService.getFormations());
        return "dashboard/dashboardReferentiels";
    }
}
