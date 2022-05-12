package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.models.entities.Centre;
import com.cda.contenu_seance.models.entities.Seance;
import com.cda.contenu_seance.models.entities.Session;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
public class IntervenantDTO {
    private Long id;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    @Size(min = 2, max = 50, message = "Le champ doit contenir de 2 à 50 caractère")
    private String nom;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    @Size(min = 2, max = 50, message = "Le champ doit contenir de 2 à 50 caractère")
    private String prenom;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    @Email(message = "Le champ doit contenir un @")
    private String email;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    @Size(min = 10, max = 50, message = "Le champ doit contenir de 10 à 50 caractère")
    private String mp;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide")
    private String codePostal;
    @NotEmpty(message = "Le champ ne peut pas être vide")
    @NotBlank(message = "Le champ ne peut pas contenir uniquement des espaces vide last")
    private String tel;


    private List<Centre> centres;
    private List<Session> sessionsCoordonateur;
    private List<Seance> seances;
    private List<Session> sessionsFomateur;
}
