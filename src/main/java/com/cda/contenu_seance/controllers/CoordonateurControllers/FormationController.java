package com.cda.contenu_seance.controllers.CoordonateurControllers;

import com.cda.contenu_seance.dto.FormationDTO;
import com.cda.contenu_seance.models.entities.Formation;
import com.cda.contenu_seance.services.FicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/coordonateur/dashboard")
public class FormationController implements WebMvcConfigurer {

    @Autowired
    FicheService ficheService;

    @GetMapping(value = {"/formations", "/formation/edit/{id}"})
    public String dashboardFormations(@PathVariable(required = false) Long id, FormationDTO formationDTO, Model model) {
        // Tableau
        model.addAttribute("formations", ficheService.getAllFormations());
        // Form
        model.addAttribute("id", id);
        model.addAttribute("formationForm", formationDTO);
        return "dashboardCoordonateur/dashboardFormations";
    }

    @GetMapping(value = "/formation")
    public String formFormation(Model model) {
        model.addAttribute("formation", new Formation());
        return "formulaire/formation";
    }

    @PostMapping(value = "/formation/save")
    public String saveFormation(@Validated FormationDTO formationDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            model.addAttribute("formations", ficheService.getAllFormations());
            model.addAttribute("formationForm", formationDTO);
            model.addAttribute("errorForm", bindingResult.getAllErrors());
            if (null==formationDTO.getId()){
                model.addAttribute("formations", ficheService.getAllFormations());
                return "dashboardCoordonateur/dashboardFormations";
            } else {
                Long id = formationDTO.getId();
                model.addAttribute("formations", ficheService.getAllFormations());
                model.addAttribute("id", id);
                return "dashboardCoordonateur/dashboardFormations";
            }
            //model.addAttribute("formations", ficheService.getAllFormations());
            //model.addAttribute("formationForm", new FormationDTO());
            //model.addAttribute("errorForm", bindingResult.getAllErrors());
            //return "dashboardCoordonateur/dashboardFormations";

        }
        String typeFormation = formationDTO.getTypeFormation();
        redirectAttributes.addFlashAttribute("message", "La formation '"+typeFormation+"' a bien été créer/modifier");
        ficheService.saveFormation(formationDTO);
        return "redirect:/coordonateur/dashboard/formations";
    }

    /*@PostMapping(value = "/formation/save")
    public String saveFormation(@Validated FormationDTO formationDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            model.addAttribute("formations", ficheService.getAllFormations());
            model.addAttribute("formationForm", formationDTO);
            model.addAttribute("errorForm", bindingResult.getAllErrors());
            return "dashboardCoordonateur/dashboardFormations";
        }
        ficheService.saveFormation(formationDTO);
        return "redirect:/coordonateur/dashboard/formations";
    }*/

    /*@GetMapping(value = "/formation/edit/{id}")
    public String editFormation(@PathVariable(name = "id") long id, Model model, FormationDTO formationDTO) {
        model.addAttribute("id", id);
        model.addAttribute("formationForm", formationDTO);
        return "formulaire/update/formationUpdate";
    }*/

    @GetMapping(value = "/formation/delete/{id}")
    public String deleteFormation(@PathVariable(name = "id") long id) {
        ficheService.deleteFormation(id);
        return "redirect:/coordonateur/dashboard/formations";
    }
}
