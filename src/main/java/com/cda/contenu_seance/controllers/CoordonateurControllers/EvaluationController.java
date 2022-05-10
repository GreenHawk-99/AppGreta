package com.cda.contenu_seance.controllers.CoordonateurControllers;

import com.cda.contenu_seance.dto.EvaluationDTO;
import com.cda.contenu_seance.services.FicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/coordonateur/dashboard")
public class EvaluationController {
    @Autowired
    FicheService ficheService;

    @GetMapping(value= {"/evaluations", "/evaluation/edit/{id}"})
    public String dashboardEvaluation(@PathVariable(required = false) Long id, EvaluationDTO evaluationDTO, Model model) {
        // Tableau
        model.addAttribute("evaluations", ficheService.getAllEvaluations());
        //Form
        model.addAttribute("id", id);
        model.addAttribute("evaluationForm", evaluationDTO);
        return "dashboardCoordonateur/dashboardEvaluation";
    }

    @PostMapping(value = "/evaluation/save")
    public String saveEvaluation(@Validated EvaluationDTO evaluationDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        String action="";
        if (null==evaluationDTO.getId()){
            action="créée";
        }
        else {
            action="modifiée";
        }
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errorForm", bindingResult.getAllErrors());
            return "redirect:/coordonateur/dashboard/evaluation";
        }
        String modalite = evaluationDTO.getModalite();
        redirectAttributes.addFlashAttribute("message", "L'évaluation '"+modalite+"' a bien été "+action);
        ficheService.saveEvaluation(evaluationDTO);
        return "redirect:/coordonateur/dashboard/evaluation";
    }

    @PostMapping(value = "/evaluation/delete/{id}")
    public String deleteEvaluation(@PathVariable(name = "id") long id) {
        ficheService.deleteEvaluation(id);
        return "redirect:/coordonateur/dashboard/evaluation";
    }
}
