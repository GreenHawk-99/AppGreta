package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Centre;
import com.cda.contenu_seance.model.Reac;
import com.cda.contenu_seance.model.Session;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class FormationDTO {
    private Long id;
    @NotNull(message = "pipi")
    @NotEmpty(message = "caca")
    @NotBlank(message = "blanc")
    private String typeFormation;

    private List<Reac> reac;
    private List<Session> sessions;
}
