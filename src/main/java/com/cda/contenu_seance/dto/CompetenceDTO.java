package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Activite;
import com.cda.contenu_seance.model.Seance;
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
    @NotNull
    @NotEmpty
    private String competenceProfessionel;
    @NotNull
    @NotEmpty
    @NotBlank
    private int numCP;
    private Activite activite;
    private Set<Seance> seances;
}
