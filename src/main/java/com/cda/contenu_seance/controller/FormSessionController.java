package com.cda.contenu_seance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/formulaire")
public class FormSessionController {
    @GetMapping(value = "/session")
    public String formSession(){
        return "formulaire/formSession";
    }
}
