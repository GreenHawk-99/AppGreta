package com.cda.contenu_seance.controllers.CrudControllers;

import com.cda.contenu_seance.dto.SeanceDTO;
import com.cda.contenu_seance.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/formulaire")
public class FicheController {
    @Autowired
    FicheService ficheService;
    @Autowired
    ReferentielService referentielService;

    @GetMapping(value = {"/fiche"})
    public String formFiche(Model model) {
        model.addAttribute("fiche", new SeanceDTO());
        model.addAttribute("competences", referentielService.getAllCompetences());
        model.addAttribute("sessions", ficheService.getAllSessions());
        return "formulaire/fiche";
    }

    @PostMapping(value = "/fiche/save")
    public String saveFiche(@ModelAttribute(name = "fiche") SeanceDTO seanceDTO) {
        ficheService.saveFiche(seanceDTO);
        return "redirect:/dashboard/fiches";
    }

    @GetMapping(value = "/fiche/edit/{id}")
    public String editFiche(@PathVariable(name = "id") long id, Model model, SeanceDTO seanceDTO) {
        model.addAttribute("id", id);
        model.addAttribute("ficheForm", seanceDTO);
        model.addAttribute("competences", referentielService.getAllCompetences());
        model.addAttribute("sessions", ficheService.getAllSessions());
        return "formulaire/update/ficheUpdate";
    }

    @GetMapping(value = "/fiche/delete/{id}")
    public String deleteFiche(@PathVariable(name = "id") long id) {
        ficheService.deleteFiche(id);
        return "redirect:/dashboard/fiches";
    }
}