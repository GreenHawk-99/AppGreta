package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.models.entities.Competence;
import com.cda.contenu_seance.models.entities.Seance;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
public class SavoirFaireDTO {
    private Long id;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    private String nom;

    private Competence competence;
    private List<Seance> seances;
}
