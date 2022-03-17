package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.SeanceDTO;
import com.cda.contenu_seance.model.*;
import com.cda.contenu_seance.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/formulaire")
public class FormFicheController {

    private FicheService ficheService;
    private ReferencielService referencielService;
    private IntervenantService intervenantService;

    @GetMapping(value = {"/fiche"})
    public String formFiche(Model model) {
        model.addAttribute("fiche", new SeanceDTO());
        model.addAttribute("formateur", intervenantService.getFormateurs());
        model.addAttribute("activite", referencielService.getActivites());
        model.addAttribute("competence", referencielService.getCompetences());
        model.addAttribute("formation", ficheService.getFormations());
        return "page/formulaire/formFiche";
    }

    // TODO
    //  créer un modal permettant d'afficher
    //  les détails ou la modification d'un formulaire
    //  dans le dashboard

    @GetMapping("/fiche/edit/{id}")
    public String editFiche(Model model, @PathVariable(name = "id") Long id){
        Seance seance = ficheService.getFiche(id);
        SeanceDTO seanceDTO = convertSeanceEntityToSeanceDTO(seance);
        List<Formateur> formateurs = intervenantService.getFormateurs();
        List<Activite> activites = referencielService.getActivites();
        List<Competence> competences = referencielService.getCompetences();
        List<Formation> formations = ficheService.getFormations();

        model.addAttribute("fiche", seanceDTO);
        model.addAttribute("formateurs", formateurs);
        model.addAttribute("activite", activites);
        model.addAttribute("competence", competences);
        model.addAttribute("formation", formations);
        return "formulaire/formFiche";
    }

    private SeanceDTO convertSeanceEntityToSeanceDTO(Seance seance){
        SeanceDTO seanceDTO= new SeanceDTO();
        seanceDTO.setId(seance.getId());
        seanceDTO.setDateDuJour(seance.getDateDuJour());
        seanceDTO.setDurer(seance.getDurer());
        seanceDTO.setObjectifPeda(seance.getObjectifPeda());
        seanceDTO.setSupport(seance.getSupport());
        seanceDTO.setDeroulement(seance.getDeroulement());
        return seanceDTO;
    }

    @PostMapping("/fiche")
    public String postFiche(@ModelAttribute(name="fiche")SeanceDTO seance){
        ficheService.saveUpdateFiche(seance);
        return "redirect:/";
    }

    @GetMapping(value = "/fiche/delete/{id}")
    public String deleteForm(@PathVariable(name = "id") long id){
        ficheService.deleteFiche(id);
        return "redirect:/dashboard";
    }
}