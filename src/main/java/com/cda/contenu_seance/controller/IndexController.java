package com.cda.contenu_seance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping(value = {"/"})
    public String index() {
        return "page/index";
    }
    @GetMapping(value = {"/login"})
    public String login() {
        return "page/login";
    }
    @GetMapping(value = {"/form"})
    public String form() {
        return "page/form";
    }
}
