package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.service.FicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/formulaire")
public class CentreController {
    @Autowired
    FicheService ficheService;

    @GetMapping(value = "/centre")
    public String formCentre(Model model) {
        model.addAttribute("centres", ficheService.getCentres());
        return "formulaire/centre";
    }

    @PostMapping(value = "/centre/save")
    public String addCentre(@ModelAttribute(name = "centre") CentreDTO centreDTO) {
        ficheService.saveCentre(centreDTO);
        return "redirect:/dashboard/centres";
    }

    @GetMapping(value = "/centre/edit/{id}")
    public String editCentre(Model model, @PathVariable(name = "id") long id) {
        model.addAttribute("id", id);
        return "formulaire/update/centreUpdate";
    }

    @GetMapping(value = "/centre/delete/{id}")
    public String deleteCentre(@PathVariable(name = "id") long id) {
        ficheService.deleteCentre(id);
        return "redirect:/dashboard/centres";
    }
}
