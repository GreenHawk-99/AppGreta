package com.cda.contenu_seance.controllers.CoordonateurControllers;

import com.cda.contenu_seance.dto.ActiviteDTO;
import com.cda.contenu_seance.models.entities.Activite;
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
public class ActiviteController {
    @Autowired
    ReferentielService referentielService;

    @GetMapping(value = {"/activites", "/activite/edit/{id}"})
    public String dashboardActivites(@PathVariable(required = false) Long id, ActiviteDTO activiteDTO, Model model) {
        // Tableau
        model.addAttribute("activites", referentielService.getAllActivites());
        // Form
        model.addAttribute("id", id);
        model.addAttribute("activiteForm", activiteDTO);
        model.addAttribute("reacs", referentielService.getAllReacs());
        return "dashboardCoordonateur/dashboardActivites";
    }

    @GetMapping(value = "/activite")
    public String formActivite(Model model) {
        model.addAttribute("activite", new Activite());
        model.addAttribute("reacs", referentielService.getAllReacs());
        return "formulaire/activite";
    }

    @PostMapping(value = "/activite/save")
    public String addActivite(@Validated ActiviteDTO activiteDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        String action="";
        if (null==activiteDTO.getId()){
            action="créée";
        }
        else {
            action="modifiée";
        }
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errorForm", bindingResult.getAllErrors());
            return "redirect:/coordonateur/dashboard/activites";
        }
        String activitesTypes = activiteDTO.getActivitesTypes();
        redirectAttributes.addFlashAttribute("message", "L'activité '"+activitesTypes+"' a bien été "+action);
        referentielService.saveActivite(activiteDTO);
        return "redirect:/coordonateur/dashboard/activites";
    }

    /*@GetMapping(value = "/activite/edit/{id}")
    public String editActivite(Model model, @PathVariable(name = "id") long id){
        model.addAttribute("id", id);
        model.addAttribute("activiteForm", new Activite());
        model.addAttribute("reacs", referentielService.getAllReacs());
        return "formulaire/update/activiteUpdate";
    }*/

    /*
    @PostMapping(value="/activite/update")
    public String updateActivite(@Validated @ModelAttribute(name = "activiteUpdate") ActiviteDTO activiteDTO){
        referentielService.updateActivite(activiteDTO);
        return "redirect:/dashboard/activites";
    }
    */

    @PostMapping(value = "/activite/delete/{id}")
    public String deleteActivite(@PathVariable(name = "id") long id){
        referentielService.deleteActivite(id);
        return "redirect:/coordonateur/dashboard/activites";
    }
}