package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.CompetenceDTO;
import com.cda.contenu_seance.model.Competence;
import com.cda.contenu_seance.service.ReferentielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/formulaire")
public class CompetenceController {
    @Autowired
    ReferentielService referentielService;

    @GetMapping(value = "/competence")
    public String formCompetence(Model model) {
        model.addAttribute("competence", new Competence());
        model.addAttribute("activites", referentielService.getActivites());
        return "formulaire/competence";
    }

    @PostMapping(value = "/competence/add")
    public String addCompetence(@ModelAttribute(name = "competence") CompetenceDTO competenceDTO){
        referentielService.saveCompetence(competenceDTO);
        return "redirect:/dashboard/competences";
    }

    @GetMapping(value = "/competence/edit/{id}")
    public String editCompetence(Model model, @PathVariable(name = "id") long id){
        model.addAttribute("id", id);
        model.addAttribute("competence", new Competence());
        model.addAttribute("activites", referentielService.getActivites());
        return "formulaire/update/competenceUpdate";
    }

    @PostMapping(value="/competence/update")
    public String updateCompetence(@ModelAttribute(name = "competenceUpdate") CompetenceDTO competenceDTO){
        referentielService.updateCompetence(competenceDTO);
        return "redirect:/dashboard/competences";
    }

    @GetMapping(value = "/competence/delete/{id}")
    public String deleteCompetence(@PathVariable(name = "id") long id){
        referentielService.deleteCompetence(id);
        return "redirect:/dashboard/competences";
    }
}