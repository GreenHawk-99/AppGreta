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
    @Temporal(TemporalType.DATE)
    private Date dateDuJour;
    private int durer;
    private String objectifPeda;
    private String support;
    private String deroulement;

    @ManyToOne
    private Formateur formateurs;
    @ManyToOne
    private Session session;
    @ManyToMany
    private List<Competence> competences;
}