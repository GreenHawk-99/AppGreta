package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Coordinateur;
import com.cda.contenu_seance.model.Formation;
import com.cda.contenu_seance.model.Session;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class CentreDTO {
    private Long id;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    private String nomCentre;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    private String adresseCentre;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    private String codesPostal;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    private String ville;

    private List<Session> sessions;
    private Coordinateur coordinateurs;
}
