package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.service.FicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/formulaire")
public class FormCentreController {

    @Autowired
    FicheService ficheService;

    @GetMapping(value = "/centre")
    public String formCentre(Model model){
        return "formulaire/formCentre";
    }

    @GetMapping(value = "/centrelist")
    public String traitForm(Model model){
        model.addAttribute("centres", ficheService.getCentres());
        return "coordinateur/listCentre";
    }
    @PostMapping(value = "/centre/add")
    public String postCentre(@ModelAttribute(name = "centre") CentreDTO centreDTO){
        ficheService.saveUpdateCentre(centreDTO);
        return "redirect:/formulaire/centrelist";
    }
}
