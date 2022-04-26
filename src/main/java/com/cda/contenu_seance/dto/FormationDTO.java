package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.models.entities.Centre;
import com.cda.contenu_seance.models.entities.Reac;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class FormationDTO {
    private Long id;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    @Size(min = 2, max = 20, message = "Le champ doit contenir de 2 à 20 caractère")
    private String typeFormation;

    private List<Reac> reac;
    private Centre centre;
}
