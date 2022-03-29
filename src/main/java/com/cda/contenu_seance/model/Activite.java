package com.cda.contenu_seance.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String activitesTypes;
    private int numAT;

    @OneToMany(mappedBy = "activite")
    private List<Competence> competences;
    @ManyToOne
    private Reac reac;
}