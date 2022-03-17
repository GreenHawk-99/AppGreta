package com.cda.contenu_seance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/formulaire")
public class FormCentreController {
    @GetMapping(value = "/centre")
    public String formCentre(){
        return "formulaire/formCentre";
    }

    @GetMapping(value = "/tf")
    public String traitForm(){

        return "traitementForm";
    }
    @PostMapping(value = "/centre/add")
    public String postCentre(){
        return "redirect:/formulaire/tf";
    }
}
