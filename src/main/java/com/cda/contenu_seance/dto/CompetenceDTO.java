package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.models.entities.Activite;
import com.cda.contenu_seance.models.entities.Seance;
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
    // Validateurs me permettant de mettre des limitesq à mes formulaires reçus
    //@NotEmpty n'accepte pas les champs vide
    @NotEmpty(message = "Le champ ne peut pas être vide")
    //@NotBlank n'accepte pas les champs remplis uniquement
    // de caractère dit "blanc" telle que les espaces
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    private String competenceProfessionel;
    @NotNull(message = "Le champ ne doit pas être null")

    private int numCP;

    private Activite activite;
    private Set<Seance> seances;
}
