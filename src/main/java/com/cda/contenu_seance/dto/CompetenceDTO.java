package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.models.Activite;
import com.cda.contenu_seance.models.Seance;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
public class CompetenceDTO {
    private Long id;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    private String competenceProfessionel;
    @NotNull(message = "Le champ ne doit pas être null")
    @NotEmpty(message = "Le champ ne peut pas être vide")
    private int numCP;

    private Activite activite;
    private Set<Seance> seances;
}
