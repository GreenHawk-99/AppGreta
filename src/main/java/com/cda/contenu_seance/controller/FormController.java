package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.SeanceDTO;
import com.cda.contenu_seance.model.*;
import com.cda.contenu_seance.service.FicheService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/formulaire")
public class FormController {

    private FicheService ficheService;

    @GetMapping(value = {"/fiche"})
    public String addForm(Model model) {
        model.addAttribute("fiche", new SeanceDTO());
        model.addAttribute("formateur", ficheService.getFormateurs());
        model.addAttribute("activite",ficheService.getActivites());
        model.addAttribute("competence", ficheService.getCompetences());
        model.addAttribute("formation", ficheService.getFormations());
        return "page/formulaire/formFicheSuivi";
    }

    // TODO
    //  créer un modal permettant d'afficher
    //  les détails ou la modification d'un formulaire
    //  dans le dashboard

    @GetMapping("fiche/edit/{id}")
    public String editFiche(Model model, @PathVariable(name = "id") Long id){
        Seance seance = ficheService.getFiche(id);
        SeanceDTO seanceDTO = convertSeanceEntityToSeanceDTO(seance);
        List<Formateur> formateurs = ficheService.getFormateurs();
        List<Activite> activites = ficheService.getActivites();
        List<Competence> competences = ficheService.getCompetences();
        List<Formation> formations = ficheService.getFormations();

        model.addAttribute("fiche", seanceDTO);
        model.addAttribute("formateurs", formateurs);
        model.addAttribute("activite", activites);
        model.addAttribute("competence", competences);
        model.addAttribute("formation", formations);
        return "page/formulaire/formFicheSuivi";
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
        ficheService.saveFiche(seance);
        return "redirect:/";
    }

    @GetMapping(value = "fiche/delete/{id}")
    public String deleteForm(@PathVariable(name = "id") long id){
        ficheService.deleteFiche(id);
        return "redirect:/dashboard";
    }

    @GetMapping("act-comp")
    public String actcompForm(){
        return "page/";
    }
}