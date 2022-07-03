package com.cda.contenu_seance.controllers.CoordonateurControllers;

import com.cda.contenu_seance.dto.SavoirFaireDTO;
import com.cda.contenu_seance.services.FicheService;
import com.cda.contenu_seance.services.ReferentielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/coordonateur/dashboard")
public class SavoirFaireController {
    @Autowired
    FicheService ficheService;
    @Autowired
    ReferentielService referentielService;

    @GetMapping(value= {"/savoirfaires", "/savoirfaire/edit/{id}"})
    public String dashboardSavoirFaire(@PathVariable(required = false) Long id, SavoirFaireDTO savoirFaireDTO, Model model) {
        // Tableau
        model.addAttribute("savoirfaires", ficheService.getAllSavoirFaires());
        //Form
        model.addAttribute("id", id);
        model.addAttribute("savoirfaireForm", savoirFaireDTO);
        model.addAttribute("fiches", ficheService.getAllFiches());
        model.addAttribute("competences", referentielService.getAllCompetences());
        return "dashboardCoordonateur/dashboardSavoirFaire";
    }

    @PostMapping(value = "/savoirfaire/save")
    public String saveSavoirFaire(@Validated SavoirFaireDTO savoirFaireDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        String action="";
        if (null==savoirFaireDTO.getId()){
            action="créée";
        }
        else {
            action="modifiée";
        }
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errorForm", bindingResult);
            return "redirect:/coordonateur/dashboard/savoirfaires";
        }
        String modalite = savoirFaireDTO.getNom();
        redirectAttributes.addFlashAttribute("message", "Le savoir faire '"+modalite+"' a bien été "+action);
        ficheService.saveSavoirFaire(savoirFaireDTO);
        return "redirect:/coordonateur/dashboard/savoirfaires";
    }

    @PostMapping(value = "/savoirfaire/delete/{id}")
    public String deleteSavoirFaire(@PathVariable(name = "id") long id) {
        ficheService.deleteSavoirFaire(id);
        return "redirect:/coordonateur/dashboard/savoirfaires";
    }
}
