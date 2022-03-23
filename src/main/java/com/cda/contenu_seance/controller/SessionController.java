package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.SessionDTO;
import com.cda.contenu_seance.service.FicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/formulaire")
public class SessionController {
    @Autowired
    FicheService ficheService;

    @GetMapping(value = "/sessions")
    public String formSession(Model model) {
        model.addAttribute("sessions", ficheService.getSessions());
        return "formulaire/session";
    }

    @PostMapping(value = "/sessions/add")
    public String addSession(@ModelAttribute(name = "session") SessionDTO sessionDTO){
        ficheService.saveSession(sessionDTO);
        return "redirect:/dashboard/sessions";
    }

    @GetMapping(value = "/sessions/edit/{id}")
    public String editSession(Model model, @PathVariable(name = "id") long id){
        model.addAttribute("id", id);
        return "formulaire/sessionUpdate";
    }

    @PostMapping(value="/sessions/update")
    public String updateSession(@ModelAttribute(name = "centreUpdate") SessionDTO sessionDTO){
        ficheService.updateSession(sessionDTO);
        return "redirect:/dashboard/sessions";
    }

    @GetMapping(value = "/sessions/delete/{id}")
    public String deleteSession(@PathVariable(name = "id") long id){
        ficheService.deleteSession(id);
        return "redirect:/dashboard/sessions";
    }
}