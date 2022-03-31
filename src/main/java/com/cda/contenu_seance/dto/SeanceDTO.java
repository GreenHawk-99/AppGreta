package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Competence;
import com.cda.contenu_seance.model.Formateur;
import com.cda.contenu_seance.model.Session;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SeanceDTO {
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDuJour;
    private int durer;
    private String objectifPeda;
    private String support;
    private String deroulement;
    private Formateur formateur;
    private Session session;
    private List<Competence> competences;
}
