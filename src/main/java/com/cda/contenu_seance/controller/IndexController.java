package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.service.*;
import com.cda.contenu_seance.dto.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
