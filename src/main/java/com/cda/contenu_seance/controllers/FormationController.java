package com.cda.contenu_seance.controllers;

import com.cda.contenu_seance.dto.FormationDTO;
import com.cda.contenu_seance.models.Formation;
import com.cda.contenu_seance.services.FicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping(value = "/formulaire")
public class FormationController implements WebMvcConfigurer {

    @Autowired
    FicheService ficheService;

    @GetMapping(value = "/formation")
    public String formFormation(Model model) {
        model.addAttribute("formation", new Formation());
        return "formulaire/formation";
    }

    @PostMapping(value = "/formation/save")
    public String addFormation(@Validated FormationDTO formationDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("formations", ficheService.getFormations());
            model.addAttribute("formationForm", new FormationDTO());
            model.addAttribute("errorForm", bindingResult.getAllErrors());
            return "dashboard/dashboardFormations";
        }
        ficheService.saveFormation(formationDTO);
        return "redirect:/dashboard/formations";
    }

    @GetMapping(value = "/formation/edit/{id}")
    public String editFormation(@PathVariable(name = "id") long id, Model model, FormationDTO formationDTO) {
        model.addAttribute("id", id);
        model.addAttribute("formationForm", formationDTO);
        return "formulaire/update/formationUpdate";
    }

    @GetMapping(value = "/formation/delete/{id}")
    public String deleteFormation(@PathVariable(name = "id") long id) {
        ficheService.deleteFormation(id);
        return "redirect:/dashboard/formations";
    }
}
