package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Centre;
import com.cda.contenu_seance.model.Reac;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class FormationDTO {
    private Long id;
    @NotNull@NotEmpty@NotBlank
    private String typeFormation;
    private List<Reac> reac;
    private Centre centre;
}
