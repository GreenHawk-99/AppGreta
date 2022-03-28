package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.CompetenceDTO;
import com.cda.contenu_seance.dto.SessionDTO;
import com.cda.contenu_seance.service.FicheService;
import com.cda.contenu_seance.service.ReferencielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/formulaire")
public class CompetenceController {
    @Autowired
    ReferencielService referencielService;

    @GetMapping(value = "/comptence")
    public String formCompetence(Model model) {
        model.addAttribute("comptences", referencielService.getCompetences());
        return "formulaire/comptence";
    }

    @PostMapping(value = "/comptence/add")
    public String addCompetence(@ModelAttribute(name = "comptence") CompetenceDTO competenceDTO){
        referencielService.saveCompetence(competenceDTO);
        return "redirect:/dashboard/comptences";
    }

    @GetMapping(value = "/comptence/edit/{id}")
    public String editCompetence(Model model, @PathVariable(name = "id") long id){
        model.addAttribute("id", id);
        return "formulaire/update/comptenceUpdate";
    }

    @PostMapping(value="/comptence/update")
    public String updateCompetence(@ModelAttribute(name = "comptenceUpdate") CompetenceDTO competenceDTO){
        referencielService.updateCompetence(competenceDTO);
        return "redirect:/dashboard/comptences";
    }

    @GetMapping(value = "/comptence/delete/{id}")
    public String deleteCompetence(@PathVariable(name = "id") long id){
        referencielService.deleteCompetence(id);
        return "redirect:/dashboard/comptences";
    }
}