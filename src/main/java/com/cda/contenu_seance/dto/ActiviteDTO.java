package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Competence;
import com.cda.contenu_seance.model.Reac;
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
    @NotNull
    @NotEmpty
    private String activitesTypes;
    @NotNull
    @NotEmpty
    @NotBlank
    private int numAT;
    private List<Competence> competences;
    private Reac reac;
}
