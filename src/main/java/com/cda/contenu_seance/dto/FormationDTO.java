package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Centre;
import com.cda.contenu_seance.model.Reac;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class FormationDTO {
    private Long id;
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 20)
    private String typeFormation;
    private List<Reac> reac;
    private Centre centre;
}
