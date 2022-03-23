package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.service.FicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/formulaire")
public class FormationController {
    @Autowired
    FicheService ficheService;

    @GetMapping(value = "/formations")
    public String formFormation(Model model){
        model.addAttribute("centres", ficheService.getCentres());
        return "formulaire/centre";
    }

    @PostMapping(value = "/formations/add")
    public String addFormation(@ModelAttribute(name = "centre") CentreDTO centreDTO){
        ficheService.saveCentre(centreDTO);
        return "redirect:/dashboard/formations";
    }

    @GetMapping(value = "/formations/edit/{id}")
    public String editFormation(Model model, @PathVariable(name = "id") long id){
        model.addAttribute("id", id);
        return "formulaire/formationUpdate";
    }

    @PostMapping(value="/formations/update")
    public String updateFormation(@ModelAttribute(name = "centreUpdate") CentreDTO centreDTO){
        ficheService.updateCentre(centreDTO);
        return "redirect:/dashboard/formations";
    }

    @GetMapping(value = "/formations/delete/{id}")
    public String deleteFormation(@PathVariable(name = "id") long id){
        ficheService.deleteCentre(id);
        return "redirect:/dashboard/formations";
    }
}
