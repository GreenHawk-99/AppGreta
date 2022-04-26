package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.models.entities.Competence;
import com.cda.contenu_seance.models.entities.Reac;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class ActiviteDTO {
    private Long id;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    private String activitesTypes;
    @NotNull(message = "Le champ ne doit pas être null")
    @NotEmpty(message = "Le champ ne peut pas être vide")
    private int numAT;

    private List<Competence> competences;
    private Reac reac;
}
