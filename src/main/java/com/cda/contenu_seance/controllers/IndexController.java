package com.cda.contenu_seance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = {"home"})
    public String index(){
        return "display/index";
    }

    @GetMapping(value = {"/login"})
    public String login(){
        return "display/login";
    }
}
