package com.cda.contenu_seance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/formulaire")
public class FormController {

    @GetMapping(value = {"/fichesuivi"})
    public String addForm() {
        return "page/formulaire/formFicheSuivi";
    }

    @GetMapping(value = "film/delete/{id}")
    public String deleteForm(@PathVariable(name = "id") long id) {

        return "redirect:/fichedesuivi";
    }
}
