package com.cda.contenu_seance.controllers.CrudControllers;

import com.cda.contenu_seance.dto.IntervenantDTO;
import com.cda.contenu_seance.services.IntervenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/formulaire")
public class FormateurController {
    @Autowired
    IntervenantService intervenantService;

    @GetMapping(value = "/formateur")
    public String formFormateur(Model model) {
        model.addAttribute("formateurForm", new IntervenantDTO());
        return "formulaire/formateur";
    }

    @PostMapping(value = "/formateur/save")
    public String addFormateur(@ModelAttribute(name = "formateur") IntervenantDTO intervenantDTO) {
        intervenantService.saveFormateur(intervenantDTO);
        return "redirect:/dashboard/formateurs";
    }

    @GetMapping(value = "/formateur/edit/{id}")
    public String editFormateur(Model model, @PathVariable(name = "id") long id) {
        model.addAttribute("id", id);
        model.addAttribute("formateurForm", new IntervenantDTO());
        return "formulaire/update/formateurUpdate";
    }

    @GetMapping(value = "/formateur/delete/{id}")
    public String deleteFormateur(@PathVariable(name = "id") long id) {
        intervenantService.deleteFormateur(id);
        return "redirect:/dashboard/formateurs";
    }
}
