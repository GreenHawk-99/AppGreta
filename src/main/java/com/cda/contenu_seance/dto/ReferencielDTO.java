package com.cda.contenu_seance.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class ReferencielDTO {
    // Reac
    private Long idReac;
    private String lien;
    private Date dateDebut;
    private Long durer;

    //private Formation formation;
    //private List<Activite> activites;

    // Activite
    private Long idActivite;
    @NotNull
    private String activitesTypes;
    private int numbOrdre;

    //private List<Competence> competences;
    //private Reac reac;
}
