package com.cda.contenu_seance.controllers.CoordonateurControllers;

import com.cda.contenu_seance.dto.ReacDTO;
import com.cda.contenu_seance.services.FicheService;
import com.cda.contenu_seance.services.ReferentielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/coordonateur/dashboard")
public class ReferentielController {

    ReferentielService referentielService;
    FicheService ficheService;

    @GetMapping(value = "/referentiels")
    public String dashboardReac(Model model) {
        // Tableau
        model.addAttribute("reacs", referentielService.getAllReacs());
        model.addAttribute("activites", referentielService.getAllActivites());
        model.addAttribute("competences", referentielService.getAllCompetences());
        // Form
        model.addAttribute("reacForm", new ReacDTO());
        model.addAttribute("formations", ficheService.getAllFormations());
        return "dashboardCoordonateur/dashboardReferentiels";
    }

    @Autowired
    public ReferentielController(ReferentielService referentielService,
                                 FicheService ficheService) {
        this.referentielService = referentielService;
        this.ficheService = ficheService;
    }

    @GetMapping(value = "/referentiel")
    public String formReferenciel(Model model) {
        model.addAttribute("reacDTO", new ReacDTO());
        model.addAttribute("formations", ficheService.getAllFormations());
        return "formulaire/referentiel";
    }

    @PostMapping(value = "/referentiel/save")
    public String addReferenciel(@Validated @ModelAttribute(name = "referentiel") ReacDTO reacDTO) {
        referentielService.saveReac(reacDTO);
        return "redirect:/coordonateur/dashboard/referentiels";
    }

    @GetMapping(value = "/referentiel/edit/{id}")
    public String editReferenciel(Model model, @PathVariable(name = "id") long id) {
        model.addAttribute("id", id);
        model.addAttribute("reacForm", new ReacDTO());
        model.addAttribute("formations", ficheService.getAllFormations());
        return "formulaire/update/referentielUpdate";
    }

    @GetMapping(value = "/referentiel/delete/{id}")
    public String deleteReferenciel(@PathVariable(name = "id") long id) {
        referentielService.deleteReac(id);
        return "redirect:/coordonateur/dashboard/referentiels";
    }
}
