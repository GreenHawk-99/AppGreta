package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.ReacDTO;
import com.cda.contenu_seance.model.Formation;
import com.cda.contenu_seance.service.FicheService;
import com.cda.contenu_seance.service.ReferentielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/formulaire")
public class ReferentielController {

    ReferentielService referentielService;
    FicheService ficheService;

    @Autowired
    public ReferentielController(ReferentielService referentielService,
                                 FicheService ficheService) {
        this.referentielService = referentielService;
        this.ficheService = ficheService;
    }

    @GetMapping(value = "/referentiel")
    public String formReferenciel(Model model) {
        model.addAttribute("reacDTO", new ReacDTO());
        model.addAttribute("formations", ficheService.getFormations());
        return "formulaire/referentiel";
    }

    @PostMapping(value = "/referentiel/save")
    public String addReferenciel(@Validated @ModelAttribute(name = "referentiel") ReacDTO reacDTO) {
        referentielService.saveReac(reacDTO);
        return "redirect:/dashboard/referentiels";
    }

    @GetMapping(value = "/referentiel/edit/{id}")
    public String editReferenciel(Model model, @PathVariable(name = "id") long id) {
        model.addAttribute("id", id);
        model.addAttribute("reacForm", new ReacDTO());
        model.addAttribute("formations", ficheService.getFormations());
        return "formulaire/update/referentielUpdate";
    }

    @GetMapping(value = "/referentiel/delete/{id}")
    public String deleteReferenciel(@PathVariable(name = "id") long id) {
        referentielService.deleteReac(id);
        return "redirect:/dashboard/referentiels";
    }
}
