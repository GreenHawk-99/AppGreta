package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.SeanceDTO;
import com.cda.contenu_seance.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/formulaire")
public class FicheController {
    @Autowired
    FicheService ficheService;

    @GetMapping(value = {"/fiche"})
    public String formFiche(Model model) {
        model.addAttribute("fiches", ficheService.getFiches());
        return "formulaire/fiche";
    }

    @PostMapping(value = "/fiche/add")
    public String saveFiche(@ModelAttribute(name = "session") SeanceDTO seanceDTO){
        ficheService.saveFiche(seanceDTO);
        return "redirect:/dashboard/fiches";
    }

    @GetMapping(value = "/fiche/edit/{id}")
    public String editFiche(Model model, @PathVariable(name = "id") long id) {
        model.addAttribute("id", id);
        return "formulaire/ficheUpdate";
    }

    @PostMapping(value = "/fiche/update")
    public String updateFiche(@ModelAttribute(name = "sessionUpdate") SeanceDTO seanceDTO){
        ficheService.updateFiche(seanceDTO);
        return "redirect:/dashboard/fiches";
    }

    @GetMapping(value = "/fiche/delete/{id}")
    public String deleteFiche(@PathVariable(name = "id") long id){
        ficheService.deleteFiche(id);
        return "redirect:/dashboard/fiches";
    }
}