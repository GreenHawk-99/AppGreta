package com.cda.contenu_seance.controllers.CoordonateurControllers;

import com.cda.contenu_seance.dto.SessionDTO;
import com.cda.contenu_seance.services.FicheService;
import com.cda.contenu_seance.services.IntervenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping(value = "/coordonateur/dashboard")
public class SessionController {
    @Autowired
    FicheService ficheService;
    @Autowired
    IntervenantService intervenantService;

    @GetMapping(value = {"/sessions", "/session/edit/{id}"})
    public String dashboardSessions(@PathVariable(required = false) Long id, SessionDTO sessionDTO, Model model) {
        // Tableau
        model.addAttribute("sessionsGRETA", ficheService.getAllSessions());
        model.addAttribute("formations", ficheService.getAllFormations());
        model.addAttribute("centres", ficheService.getAllCentres());
        model.addAttribute("coordinateurs", intervenantService.getAllCoordinateurs());
        model.addAttribute("formateurs", intervenantService.getAllFormateurs());
        // Form
        model.addAttribute("id", id);
        model.addAttribute("sessionForm", sessionDTO);
        return "dashboardCoordonateur/dashboardSessions";
    }

    @GetMapping(value = "/session")
    public String formSession(Model model) {
        model.addAttribute("sessionsGRETA", ficheService.getAllSessions());
        return "formulaire/session";
    }

    @PostMapping(value = "/session/save")
    public String addSession(@Validated SessionDTO sessionDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        String action="";
        if (null==sessionDTO.getId()){
            action="créée";
        }
        else {
            action="modifiée";
        }
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errorForm", bindingResult.getAllErrors());
        }
        LocalDate dateDebut = sessionDTO.getDateDebut();
        LocalDate dateFin = sessionDTO.getDateFin();
        redirectAttributes.addFlashAttribute("message", "La session du '"+dateDebut+" "+dateFin+"' a bien été créée/modifiée");
        ficheService.saveSession(sessionDTO);
        return "redirect:/coordonateur/dashboard/sessions";
    }

    /*@GetMapping(value = "/session/edit/{id}")
    public String editSession(Model model, @PathVariable(name = "id") long id) {
        model.addAttribute("id", id);
        model.addAttribute("sessionForm", new SessionDTO());
        return "formulaire/update/sessionUpdate";
    }*/

    @PostMapping(value = "/session/delete/{id}")
    public String deleteSession(@PathVariable(name = "id") long id) {
        ficheService.deleteSession(id);
        return "redirect:/coordonateur/dashboard/sessions";
    }
}