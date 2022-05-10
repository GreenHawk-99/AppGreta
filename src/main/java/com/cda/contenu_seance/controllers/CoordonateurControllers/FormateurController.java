package com.cda.contenu_seance.controllers.CoordonateurControllers;

import com.cda.contenu_seance.dto.IntervenantDTO;
import com.cda.contenu_seance.services.IntervenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/coordonateur/dashboard")
public class FormateurController {
    @Autowired
    IntervenantService intervenantService;

    @GetMapping(value = {"/formateurs", "/formateur/edit/{id}"})
    public String dashboardFormateurs(@PathVariable(required = false) Long id, IntervenantDTO intervenantDTO, Model model) {
        // Tableau
        model.addAttribute("formateurs", intervenantService.getAllFormateurs());
        // Form
        model.addAttribute("id", id);
        model.addAttribute("formateurForm", intervenantDTO);
        return "dashboardCoordonateur/dashboardFormateurs";
    }

    @GetMapping(value = "/formateur")
    public String formFormateur(Model model) {
        model.addAttribute("formateurForm", new IntervenantDTO());
        return "formulaire/formateur";
    }

    @PostMapping(value = "/formateur/save")
    public String addFormateur(@Validated IntervenantDTO intervenantDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        String action="";
        if (null==intervenantDTO.getId()){
            action="créée";
        }
        else {
            action="modifiée";
        }
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errorForm", bindingResult.getAllErrors());
        }
        String nom = intervenantDTO.getNom();
        String prenom = intervenantDTO.getPrenom();
        redirectAttributes.addFlashAttribute("message", "Le formateur '"+nom+" "+prenom+"' a bien été "+action);
        intervenantService.saveFormateur(intervenantDTO);
        return "redirect:/coordonateur/dashboard/formateurs";
    }

    /*@GetMapping(value = "/formateur/edit/{id}")
    public String editFormateur(Model model, @PathVariable(name = "id") long id) {
        model.addAttribute("id", id);
        model.addAttribute("formateurForm", new IntervenantDTO());
        return "formulaire/update/formateurUpdate";
    }*/

    @PostMapping(value = "/formateur/delete/{id}")
    public String deleteFormateur(@PathVariable(name = "id") long id) {
        intervenantService.deleteFormateur(id);
        return "redirect:/coordonateur/dashboard/formateurs";
    }
}
