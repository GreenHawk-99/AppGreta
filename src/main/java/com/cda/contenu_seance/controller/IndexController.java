package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.service.FicheService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private FicheService ficheService;

    @GetMapping(value = {"/"})
    public String index(){
        return "page/index";
    }
    @GetMapping(value = {"/login"})
    public String login(){
        return "page/login";
    }
    @GetMapping(value = "/dashboard")
    public String dashboard(Model model){
        model.addAttribute("fiches", ficheService.getFiches());
        return "page/dashboard";
    }
}
