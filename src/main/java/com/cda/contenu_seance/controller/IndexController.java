package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.service.*;
import com.cda.contenu_seance.dto.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private IntervenantDTO intervenantDTO;

    private FicheService ficheService;
    private IntervenantService intervenantService;
    private ReferencielService referencielService;

    @GetMapping(value = {"/"})
    public String index(){
        return "page/index";
    }
    @GetMapping(value = {"/login"})
    public String login(){
        return "page/login";
    }

    // TODO faire route CRUD avec les services

    @GetMapping(value = "/dashboard")
    public String dashboard(Model model){
        model.addAttribute("fiches", ficheService.getFiches());
        model.addAttribute("formateur", intervenantDTO);
        model.addAttribute("formation", referencielService);
        return "coordinateur/dashboard";
    }
}
