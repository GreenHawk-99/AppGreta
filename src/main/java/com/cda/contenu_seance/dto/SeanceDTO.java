package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.models.entities.Competence;
import com.cda.contenu_seance.models.entities.Evaluation;
import com.cda.contenu_seance.models.entities.Formateur;
import com.cda.contenu_seance.models.entities.Session;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class SeanceDTO {
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDuJour;
    @NotNull
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @Min(value = 3, message = "La durée du cours ne peut pas être inférieur à 3 heures")
    @Max(value = 4, message = "La durée du cours ne peut pas être sipérieur à 4 heures")
    private int duree;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    private String objectifPeda;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    private String methodeEnvisage;

    private String support;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    private String deroulement;

    private Formateur formateur;
    private Session session;
    private Competence competence;
    private Evaluation evaluation;
}
