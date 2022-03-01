package com.cda.contenu_seance.model;

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
    private String lien;
    private Date dateDebut;
    private Long durer;

    @ManyToOne
    private Formation formation;
    @OneToMany(mappedBy = "reac")
    private List<Activite> activites;
}