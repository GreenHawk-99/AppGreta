package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.service.FicheService;
import com.cda.contenu_seance.service.IntervenantService;
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
    IntervenantService intervenantService;
    FicheService ficheService;
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
        model.addAttribute("formateurs", intervenantService.getFormateurs());
        return "dashboard/dashboardFormateurs";
    }

    @GetMapping(value = "/sessions")
    public String dashboardSessions(Model model){
        model.addAttribute("sessions", ficheService.getSessions());
        return "dashboard/dashboardSessions";
    }

    /*
    @GetMapping(value = "/referenciels")
    public String dashboardReac(Model model){
        model.addAttribute("referenciels", referencielService.getReferenciels());
        return "dashboard/dashboardReferenciels";
    }
     */
}
