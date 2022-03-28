package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.dto.ReacDTO;
import com.cda.contenu_seance.service.FicheService;
import com.cda.contenu_seance.service.ReferencielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/formulaire")
public class ReferencielController {
    @Autowired
    ReferencielService referencielService;

    @GetMapping(value = "/referenciel")
    public String formReferenciel(Model model){
        model.addAttribute("centres", referencielService.getReacs());
        return "formulaire/referenciel";
    }

    @PostMapping(value = "/referenciel/add")
    public String addReferenciel(@ModelAttribute(name = "centre") ReacDTO reacDTO){
        referencielService.saveReac(reacDTO);
        return "redirect:/dashboard/referenciels";
    }

    @GetMapping(value = "/referenciel/edit/{id}")
    public String editReferenciel(Model model, @PathVariable(name = "id") long id){
        model.addAttribute("id", id);
        return "formulaire/update/referencielUpdate";
    }

    @PostMapping(value="/referenciel/update")
    public String updateReferenciel(@ModelAttribute(name = "referencielUpdate") ReacDTO reacDTO){
        referencielService.updateReac(reacDTO);
        return "redirect:/dashboard/referenciels";
    }

    @GetMapping(value = "/referenciel/delete/{id}")
    public String deleteReferenciel(@PathVariable(name = "id") long id){
        referencielService.deleteReac(id);
        return "redirect:/dashboard/referenciels";
    }
}
