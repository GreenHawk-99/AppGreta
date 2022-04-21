package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Competence;
import com.cda.contenu_seance.model.Formateur;
import com.cda.contenu_seance.model.Session;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SeanceDTO {
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDuJour;
    @NotNull
    @NotEmpty(message = "Le champ ne peut pas être vide")
    private int duree;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    private String objectifPeda;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    private String support;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    private String deroulement;

    private Formateur formateur;
    private Session session;
    private List<Competence> competences;
}
