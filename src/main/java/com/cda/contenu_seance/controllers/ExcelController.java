package com.cda.contenu_seance.controllers;

import com.cda.contenu_seance.services.ImportExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class ExcelController {

    @Autowired
    ImportExcelService importExcelService;

    @PostMapping("/import")
    public String postImportExcel(@RequestParam("import") MultipartFile multipartFile, RedirectAttributes redirectAttributes) throws IOException {
        importExcelService.generateDataFromExcel(multipartFile.getInputStream());
        redirectAttributes.addFlashAttribute("message", "Le fichier à bien été importé");
        return "redirect:/welcome";
    }
}
