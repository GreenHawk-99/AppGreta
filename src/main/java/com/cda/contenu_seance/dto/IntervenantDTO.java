package com.cda.contenu_seance.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class IntervenantDTO {
    private Long id;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 1, max = 50)
    private String nom;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 1, max = 50)
    private String prenom;
    @NotNull
    @NotEmpty
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotEmpty
    @NotBlank
    private String mp;
    @NotNull
    @NotEmpty
    @NotBlank
    private String codePostal;
    @NotNull
    @NotEmpty
    private String tel;
}
