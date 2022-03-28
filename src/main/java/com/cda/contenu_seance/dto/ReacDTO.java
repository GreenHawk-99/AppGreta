package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Activite;
import com.cda.contenu_seance.model.Formation;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ReacDTO {
    private Long id;
    private String nom;
    private String lien;
    private Date dateDebut;
    private Long durer;
    private Formation formations;
    private List<Activite> activites;
}
