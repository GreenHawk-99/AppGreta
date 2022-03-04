package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Coordinateur;
import com.cda.contenu_seance.model.Formation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CentreDTO {
    private Long id;
    private String nomCentre;
    private String adresseCentre;
    private String codesPostal;
    private String ville;
    private List<Formation> formations;
    private Coordinateur coordinateurs;
}
