package com.cda.contenu_seance.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String lien;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    private int duree;

    @ManyToOne
    private Formation formation;
    @OneToMany(mappedBy = "reac")
    private List<Activite> activites;
}