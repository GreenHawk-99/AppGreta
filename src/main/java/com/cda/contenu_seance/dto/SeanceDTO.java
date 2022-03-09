package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Formateur;
import com.cda.contenu_seance.model.Session;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SeanceDTO {
    private Long id;
    private Date dateDuJour;
    private int durer;
    private String objectifPeda;
    private String support;
    private String deroulement;
    private Formateur formateur;
    private Session session;
}
