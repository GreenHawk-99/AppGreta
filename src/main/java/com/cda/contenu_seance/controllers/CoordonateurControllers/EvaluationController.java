package com.cda.contenu_seance.controllers.CoordonateurControllers;

import com.cda.contenu_seance.dto.EvaluationDTO;
import com.cda.contenu_seance.services.FicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/coordonateur/dashboard")
public class EvaluationController {
    @Autowired
    FicheService ficheService;

    @GetMapping(value="/evaluations")
    public String dashboardEvaluation(Model model) {
        // Tableau
        model.addAttribute("evaluations", ficheService.getAllEvaluations());
        //Form
        model.addAttribute("evaluationForm", new EvaluationDTO());
        return "dashboardEvaluation";
    }

    @PostMapping(value = "/evaluation/save")
    public String saveEvaluation(EvaluationDTO evaluationDTO) {
        ficheService.saveEvaluation(evaluationDTO);
        return "redirect:/coordonateur/dashboard/evaluation";
    }

    @GetMapping(value = "/evaluation/edit/{id}")
    public String editEvaluation(@PathVariable(name = "id") long id, Model model, EvaluationDTO evaluationDTO) {
        model.addAttribute("id", id);
        model.addAttribute("evaluationForm", evaluationDTO);
        return "formulaire/update/evaluationUpdate";
    }

    @GetMapping(value = "/evaluation/delete/{id}")
    public String deleteEvaluation(@PathVariable(name = "id") long id) {
        ficheService.deleteEvaluation(id);
        return "redirect:/coordonateur/dashboard/evaluation";
    }
}
