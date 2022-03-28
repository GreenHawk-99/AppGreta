package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.service.FicheService;
import com.cda.contenu_seance.service.FormateurService;
import com.cda.contenu_seance.service.ReferencielService;
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
    ReferencielService referencielService;

    @Autowired
    public DashboardController(FicheService ficheService, FormateurService formateurService, ReferencielService referencielService) {
        this.ficheService = ficheService;
        this.formateurService = formateurService;
        this.referencielService = referencielService;
    }

    @GetMapping(value = "/centres")
    public String dashboardCentres(Model model){
        model.addAttribute("centres", ficheService.getCentres());
        return "dashboard/dashboardCentres";
    }

    @GetMapping(value = "/fiches")
    public String dashboardFiches(Model model){
        model.addAttribute("fiches", ficheService.getFiches());
        model.addAttribute("formateur", formateurService.getFormateurs());
        model.addAttribute("foramtions", ficheService.getFormations());
        return "dashboard/dashboardFiches";
    }

    @GetMapping(value = "/formateurs")
    public String dashboardFormateurs(Model model){
        model.addAttribute("formateurs", formateurService.getFormateurs());
        return "dashboard/dashboardFormateurs";
    }

    @GetMapping(value = "/formations")
    public String dashboardFormations(Model model){
        model.addAttribute("formations", ficheService.getFormations());
        model.addAttribute("sessions", ficheService.getSessions());
        return "dashboard/dashboardFormations";
    }

    @GetMapping(value = "/sessions")
    public String dashboardSessions(Model model){
        model.addAttribute("sessionsGRETA", ficheService.getSessions());
        return "dashboard/dashboardSessions";
    }

    @GetMapping(value = "/activites")
    public String dashboardActivites(Model model){
        model.addAttribute("activites", referencielService.getActivites());
        return "dashboard/dashboardActivites";
    }

    @GetMapping(value = "/competences")
    public String dashboardCompetences(Model model){
        model.addAttribute("competences", referencielService.getCompetences());
        return "dashboard/dashboardCompetences";
    }

    @GetMapping(value = "/referenciels")
    public String dashboardReac(Model model){
        model.addAttribute("reacs", referencielService.getReacs());
        model.addAttribute("activites", referencielService.getActivites());
        model.addAttribute("competences", referencielService.getCompetences());
        return "dashboard/dashboardReferenciels";
    }
}
