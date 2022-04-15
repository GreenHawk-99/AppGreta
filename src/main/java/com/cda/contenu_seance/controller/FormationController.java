package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.FormationDTO;
import com.cda.contenu_seance.service.FicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/formulaire")
public class FormationController {

    @Autowired
    FicheService ficheService;

    @GetMapping(value = "/formation")
    public String formFormation(Model model, FormationDTO formationDTO) {
        model.addAttribute("formation", formationDTO);
        return "formulaire/formation";
    }

    @PostMapping(value = "/formation/save")
    public String saveFormation(@Validated FormationDTO formationDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("formation", ficheService.getFormations());
            model.addAttribute("formationForm", formationDTO);
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
