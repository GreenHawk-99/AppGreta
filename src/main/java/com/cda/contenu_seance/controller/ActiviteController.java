package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.ActiviteDTO;
import com.cda.contenu_seance.dto.SessionDTO;
import com.cda.contenu_seance.service.FicheService;
import com.cda.contenu_seance.service.ReferencielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/formulaire")
public class ActiviteController {
    @Autowired
    ReferencielService referencielService;

    @GetMapping(value = "/activite")
    public String formActivite(Model model) {
        model.addAttribute("activites", referencielService.getActivites());
        return "formulaire/activite";
    }

    @PostMapping(value = "/activite/add")
    public String addActivite(@ModelAttribute(name = "activite") ActiviteDTO activiteDTO){
        referencielService.saveActivite(activiteDTO);
        return "redirect:/dashboard/activites";
    }

    @GetMapping(value = "/activite/edit/{id}")
    public String editActivite(Model model, @PathVariable(name = "id") long id){
        model.addAttribute("id", id);
        return "formulaire/update/activiteUpdate";
    }

    @PostMapping(value="/activite/update")
    public String updateActivite(@ModelAttribute(name = "activiteUpdate") ActiviteDTO activiteDTO){
        referencielService.updateActivite(activiteDTO);
        return "redirect:/dashboard/activites";
    }

    @GetMapping(value = "/activite/delete/{id}")
    public String deleteActivite(@PathVariable(name = "id") long id){
        referencielService.deleteActivite(id);
        return "redirect:/dashboard/activites";
    }
}