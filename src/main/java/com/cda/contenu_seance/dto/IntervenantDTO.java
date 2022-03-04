package com.cda.contenu_seance.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntervenantDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String mp;
    private String codePostal;
    private String tel;
}
