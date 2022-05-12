package com.cda.contenu_seance.controllers.FormateurControllers;

import com.cda.contenu_seance.dto.SeanceDTO;
import com.cda.contenu_seance.services.FicheService;
import com.cda.contenu_seance.services.IntervenantService;
import com.cda.contenu_seance.services.ReferentielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/formateur/dashboard")
public class FicheFController {
    FicheService ficheService;
    ReferentielService referentielService;
    IntervenantService intervenantService;

    @Autowired
    public FicheFController(FicheService ficheService, ReferentielService referentielService, IntervenantService intervenantService) {
        this.ficheService = ficheService;
        this.referentielService = referentielService;
        this.intervenantService = intervenantService;
    }

    @GetMapping(value = "/fiches")
    public String dashboardFiches(Model model) {
        // Tableau
        model.addAttribute("fiches", ficheService.getAllFiches());
        // Form
        model.addAttribute("ficheForm", new SeanceDTO());
        model.addAttribute("sessions", ficheService.getAllSessions());
        model.addAttribute("formateurs", intervenantService.getAllFormateurs());
        return "dashboardCoordonateur/dashboardFiches";
    }

    @GetMapping(value = {"/fiche"})
    public String formFiche(Model model) {
        model.addAttribute("fiche", new SeanceDTO());
        model.addAttribute("competences", referentielService.getAllCompetences());
        model.addAttribute("sessions", ficheService.getAllSessions());
        return "formulaire/fiche";
    }

    @PostMapping(value = "/fiche/save")
    public String saveFiche(@ModelAttribute(name = "fiche") SeanceDTO seanceDTO) {
        ficheService.saveFiche(seanceDTO);
        return "redirect:/coordonateur/dashboard/fiches";
    }

    @GetMapping(value = "/fiche/edit/{id}")
    public String editFiche(@PathVariable(name = "id") long id, Model model, SeanceDTO seanceDTO) {
        model.addAttribute("id", id);
        model.addAttribute("ficheForm", seanceDTO);
        model.addAttribute("sessions", ficheService.getAllSessions());
        model.addAttribute("formateurs", intervenantService.getAllFormateurs());
        return "formulaire/update/ficheUpdate";
    }

    @GetMapping(value = "/fiche/delete/{id}")
    public String deleteFiche(@PathVariable(name = "id") long id) {
        ficheService.deleteFiche(id);
        return "redirect:/coordonateur/dashboard/fiches";
    }
}