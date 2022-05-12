package com.cda.contenu_seance.controllers.CoordonateurControllers;

import com.cda.contenu_seance.dto.SeanceDTO;
import com.cda.contenu_seance.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping(value = "/coordonateur/dashboard")
public class FicheController {
    FicheService ficheService;
    ReferentielService referentielService;
    IntervenantService intervenantService;

    @Autowired
    public FicheController(FicheService ficheService, ReferentielService referentielService, IntervenantService intervenantService) {
        this.ficheService = ficheService;
        this.referentielService = referentielService;
        this.intervenantService = intervenantService;
    }

    @GetMapping(value = {"/fiches", "/fiche/edit/{id}"})
    public String dashboardFiches(@PathVariable(required = false) Long id, SeanceDTO seanceDTO, Model model) {
        // Tableau
        model.addAttribute("fiches", ficheService.getAllFiches());
        // Form
        model.addAttribute("id", id);
        model.addAttribute("ficheForm", seanceDTO);
        model.addAttribute("sessions", ficheService.getAllSessions());
        model.addAttribute("formateurs", intervenantService.getAllFormateurs());
        return "dashboardCoordonateur/dashboardFiches";
    }

    @GetMapping(value = "/fiches-vide")
    public String dashboardEmptyFiche(Model model){
        model.addAttribute("fiches", ficheService.getEmptyFiche());
        return "dashboardCoordonateur/dashboardEmptyFiches";
    }

    @GetMapping(value = {"/fiche"})
    public String formFiche(Model model) {
        model.addAttribute("fiche", new SeanceDTO());
        model.addAttribute("competences", referentielService.getAllCompetences());
        model.addAttribute("sessions", ficheService.getAllSessions());
        return "formulaire/fiche";
    }

    @PostMapping(value = "/fiche/save")
    public String saveFiche(@Validated SeanceDTO seanceDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        String action="";
        if (null==seanceDTO.getId()){
            action="créée";
        }
        else {
            action="modifiée";
        }
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errorForm", bindingResult);
            return "redirect:/coordonateur/dashboard/fiches";
        }
        LocalDate dateDuJour = seanceDTO.getDateDuJour();
        redirectAttributes.addFlashAttribute("message", "La fiche de suivi du '"+dateDuJour+"' a bien été "+action);
        ficheService.saveFiche(seanceDTO);
        return "redirect:/coordonateur/dashboard/fiches";
    }

    /*@GetMapping(value = "/fiche/edit/{id}")
    public String editFiche(@PathVariable(name = "id") long id, Model model, SeanceDTO seanceDTO) {
        model.addAttribute("id", id);
        model.addAttribute("ficheForm", seanceDTO);
        model.addAttribute("evaluations", ficheService.getAllEvaluations());
        model.addAttribute("sessions", ficheService.getAllSessions());
        model.addAttribute("formateurs", intervenantService.getAllFormateurs());
        return "formulaire/update/ficheUpdate";
    }*/

    @PostMapping(value = "/fiche/delete/{id}")
    public String deleteFiche(@PathVariable(name = "id") long id) {
        ficheService.deleteFiche(id);
        return "redirect:/coordonateur/dashboard/fiches";
    }
}