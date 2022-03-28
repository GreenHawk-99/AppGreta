package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.dto.FormationDTO;
import com.cda.contenu_seance.dto.IntervenantDTO;
import com.cda.contenu_seance.service.FicheService;
import com.cda.contenu_seance.service.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/formulaire")
public class FormateurController {
    @Autowired
    FormateurService formateurService;

    @GetMapping(value = "/formateur")
    public String formFormateur(Model model){
        model.addAttribute("formateurs", formateurService.getFormateurs());
        return "formulaire/formateur";
    }

    @PostMapping(value = "/formateur/add")
    public String addFormateur(@ModelAttribute(name = "formateur") IntervenantDTO intervenantDTO){
        formateurService.saveFormateur(intervenantDTO);
        return "redirect:/dashboard/formateurs";
    }

    @GetMapping(value = "/formateur/edit/{id}")
    public String editFormateur(Model model, @PathVariable(name = "id") long id){
        model.addAttribute("id", id);
        return "formulaire/update/formateurUpdate";
    }

    @PostMapping(value="/formateur/update")
    public String updateFormateur(@ModelAttribute(name = "formateurUpdate") IntervenantDTO intervenantDTO){
        formateurService.updateFormateur(intervenantDTO);
        return "redirect:/dashboard/formateurs";
    }

    @GetMapping(value = "/formateur/delete/{id}")
    public String deleteFormateur(@PathVariable(name = "id") long id){
        formateurService.deleteFormateur(id);
        return "redirect:/dashboard/formateurs";
    }
}
