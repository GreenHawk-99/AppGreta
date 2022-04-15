package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.service.FicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
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
    public String saveCentre(@Validated CentreDTO centreDTO, Model model) {
        ficheService.saveCentre(centreDTO);
        return "redirect:/dashboard/centres";
    }

    @GetMapping(value = "/centre/edit/{id}")
    public String editCentre(@PathVariable(name = "id") long id, Model model, CentreDTO centreDTO) {
        model.addAttribute("id", id);
        model.addAttribute("centreForm", centreDTO);
        return "formulaire/update/centreUpdate";
    }

    @GetMapping(value = "/centre/delete/{id}")
    public String deleteCentre(@PathVariable(name = "id") long id) {
        ficheService.deleteCentre(id);
        return "redirect:/dashboard/centres";
    }
}
