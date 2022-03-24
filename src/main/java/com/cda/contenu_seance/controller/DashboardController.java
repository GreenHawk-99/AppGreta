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
    @Autowired
    FicheService ficheService;
    FormateurService formateurService;
    ReferencielService referencielService;

    @GetMapping(value = "/centres")
    public String dashboardCentres(Model model){
        model.addAttribute("centres", ficheService.getCentres());
        return "dashboard/dashboardCentres";
    }

    @GetMapping(value = "/fiches")
    public String dashboardFiches(Model model){
        model.addAttribute("fiches", ficheService.getFiches());
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
        return "dashboard/dashboardFormations";
    }

    @GetMapping(value = "/sessions")
    public String dashboardSessions(Model model){
        model.addAttribute("sessions", ficheService.getSessions());
        return "dashboard/dashboardSessions";
    }

    @GetMapping(value = "/referenciels")
    public String dashboardReac(Model model){
        model.addAttribute("reacs", referencielService.getReacs());
        model.addAttribute("activites", referencielService.getActivites());
        model.addAttribute("competences", referencielService.getCompetences());
        return "dashboard/dashboardReferenciels";
    }
}
