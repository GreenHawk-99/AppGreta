package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Coordinateur;
import com.cda.contenu_seance.model.Formation;
import com.cda.contenu_seance.model.Session;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class  CentreDTO {
    private Long id;
    @NotNull
    @NotEmpty
    private String nomCentre;
    @NotNull
    @NotEmpty
    private String adresseCentre;
    @NotNull
    @NotEmpty
    private String codesPostal;
    @NotNull
    @NotEmpty
    private String ville;

    private List<Session> sessions;
    private Coordinateur coordinateurs;
}
