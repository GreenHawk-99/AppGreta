package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.dto.FormationDTO;
import com.cda.contenu_seance.service.FicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/formulaire")
public class FormationController {

    @Autowired
    FicheService ficheService;

    @GetMapping(value = "/formation")
    public String formFormation(Model model){
        model.addAttribute("formation", new FormationDTO());
        return "formulaire/formation";
    }

    @PostMapping(value = "/formation/add")
    public String addFormation(@Validated @ModelAttribute(name = "formation") FormationDTO formationDTO){
        ficheService.saveFormation(formationDTO);
        return "redirect:/dashboard/formations";
    }

    @GetMapping(value = "/formation/edit/{id}")
    public String editFormation(Model model, @PathVariable(name = "id") long id){
        model.addAttribute("formation", new FormationDTO());
        model.addAttribute("id", id);
        return "formulaire/update/formationUpdate";
    }

    @PostMapping(value="/formation/update")
    public String updateFormation(@Validated @ModelAttribute(name = "formationUpdate") FormationDTO formationDTO){
        ficheService.updateFormation(formationDTO);
        return "redirect:/dashboard/formations";
    }

    @GetMapping(value = "/formation/delete/{id}")
    public String deleteFormation(@PathVariable(name = "id") long id){
        ficheService.deleteFormation(id);
        return "redirect:/dashboard/formations";
    }
}
