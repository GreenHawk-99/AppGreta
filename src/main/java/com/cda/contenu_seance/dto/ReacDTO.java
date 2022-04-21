package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Activite;
import com.cda.contenu_seance.model.Formation;
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
public class ReacDTO {
    private Long id;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    private String nom;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    private String lien;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;
    @NotNull(message = "Le champ ne doit pas être null")
    @NotEmpty(message = "Le champ ne peut pas être vide")
    private int duree;

    private Formation formation;
    private List<Activite> activites;
}
