package com.cda.contenu_seance.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateDuJour;
    private int durer;
    private String objectifPeda;
    private String support;
    private String deroulement;

    @ManyToOne
    private Formateur formateurs;
    @ManyToOne
    private Session session;
    @ManyToMany(mappedBy = "seances")
    private List<Competence> competences;

    public Seance(Date dateDuJour, int durer, String support, String deroulement, String objectifPeda, Formateur formateurs, Session session, List<Competence> competences) {
        this.dateDuJour = dateDuJour;
        this.durer = durer;
        this.support = support;
        this.deroulement = deroulement;
        this.objectifPeda = objectifPeda;
        this.formateurs = formateurs;
        this.session = session;
        this.competences = competences;
    }
}