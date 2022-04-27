package com.cda.contenu_seance.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String competenceProfessionel;
    private int numCP;

    @ManyToOne
    private Activite activite;
    @OneToMany(mappedBy = "competence")
    private Set<Seance> seances;
}