package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.models.entities.Competence;
import com.cda.contenu_seance.models.entities.Formateur;
import com.cda.contenu_seance.models.entities.Session;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
public class SeanceDTO {
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDuJour;
    private int duree;
    private String objectifPeda;
    private String methodeEnvisage;
    private String support;
    private String deroulement;
    private String evaluation;

    private Formateur formateur;
    private Session session;
    private Competence competence;

}
