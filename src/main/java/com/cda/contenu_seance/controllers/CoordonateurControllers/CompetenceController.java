package com.cda.contenu_seance.controllers.CoordonateurControllers;

import com.cda.contenu_seance.dto.CompetenceDTO;
import com.cda.contenu_seance.models.entities.Competence;
import com.cda.contenu_seance.services.ReferentielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/coordonateur/dashboard")
public class CompetenceController {
    @Autowired
    ReferentielService referentielService;

    @GetMapping(value = {"/competences", "/competence/edit/{id}"})
    public String dashboardCompetences(@PathVariable(required = false) Long id, CompetenceDTO competenceDTO, Model model) {
        // Tableau
        model.addAttribute("competences", referentielService.getAllCompetences());
        // Form
        model.addAttribute("id", id);
        model.addAttribute("competenceForm", competenceDTO);
        model.addAttribute("activites", referentielService.getAllActivites());
        return "dashboardCoordonateur/dashboardCompetences";
    }

    @GetMapping(value = "/competence")
    public String formCompetence(Model model) {
        model.addAttribute("competence", new Competence());
        model.addAttribute("activites", referentielService.getAllActivites());
        return "formulaire/competence";
    }

    @PostMapping(value = "/competence/save")
    public String addCompetence(@Validated CompetenceDTO competenceDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        String action="";
        if (null==competenceDTO.getId()){
            action="créée";
        }
        else {
            action="modifiée";
        }
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errorForm", bindingResult);
            return "redirect:/coordonateur/dashboard/competences";
        }
        String competenceProfessionel = competenceDTO.getCompetenceProfessionel();
        redirectAttributes.addFlashAttribute("message", "La compétence '"+competenceProfessionel+"' a bien été "+action);
        referentielService.saveCompetence(competenceDTO);
        return "redirect:/coordonateur/dashboard/competences";
    }

    /*@GetMapping(value = "/competence/edit/{id}")
    public String editCompetence(Model model, @PathVariable(name = "id") long id){
        model.addAttribute("id", id);
        model.addAttribute("competenceForm", new Competence());
        model.addAttribute("activites", referentielService.getAllActivites());
        return "formulaire/update/competenceUpdate";
    }*/

    @PostMapping(value = "/competence/delete/{id}")
    public String deleteCompetence(@PathVariable(name = "id") long id){
        referentielService.deleteCompetence(id);
        return "redirect:/coordonateur/dashboard/competences";
    }
}