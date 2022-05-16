package com.cda.contenu_seance.controllers;

import com.cda.contenu_seance.models.entities.Intervenant;
import com.cda.contenu_seance.models.repositories.IntervenantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller
public class IndexController {

    IntervenantRepository intervenantRepository;

    @GetMapping(value = {"home"})
    public String index(){
        return "display/index";
    }

    @GetMapping(value = "welcome")
    public String welcome(){
        return "display/welcome";
    }

    @GetMapping(value = "admin")
    public String admin(){
        return "display/admin";
    }

    @GetMapping(value = {"login"})
    public String login(){
        return "display/login";
    }

    @GetMapping(value = "help")
    public String help(){
        return "display/help";
    }
}
