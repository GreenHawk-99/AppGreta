package com.cda.contenu_seance.controllers.CoordonateurControllers;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.services.FicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/coordonateur/dashboard")
public class CentreController {
    @Autowired
    FicheService ficheService;

    @GetMapping(value = {"/centres", "/centre/edit/{id}"})
    public String dashboardCentres(@PathVariable(required = false) Long id, CentreDTO centreDTO, Model model) {
        // Tableau
        model.addAttribute("centres", ficheService.getAllCentres());
        // Form
        model.addAttribute("id", id);
        model.addAttribute("centreForm", centreDTO);
        return "dashboardCoordonateur/dashboardCentres";
    }

    @GetMapping(value = "/centre")
    public String formCentre(Model model) {
        model.addAttribute("centres", ficheService.getAllCentres());
        return "formulaire/centre";
    }

    @PostMapping(value = "/centre/save")
    public String addCentre(@Validated CentreDTO centreDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        String action="";
        if (null==centreDTO.getId()){
            action="créée";
        }
        else {
            action="modifiée";
        }
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errorForm", bindingResult.getAllErrors());
            return "redirect:/coordonateur/dashboard/centres";
        }
        String nomCentre = centreDTO.getNomCentre();
        redirectAttributes.addFlashAttribute("message", "Le centre '"+nomCentre+"' a bien été "+action);
        ficheService.saveCentre(centreDTO);
        return "redirect:/coordonateur/dashboard/centres";
    }

    /*@GetMapping(value = "/centre/edit/{id}")
    public String editCentre(Model model, @PathVariable(name = "id") long id) {
        model.addAttribute("id", id);
        return "formulaire/update/centreUpdate";
    }*/

    @PostMapping(value = "/centre/delete/{id}")
    public String deleteCentre(@PathVariable(name = "id") long id) {
        ficheService.deleteCentre(id);
        return "redirect:/coordonateur/dashboard/centres";
    }
}
