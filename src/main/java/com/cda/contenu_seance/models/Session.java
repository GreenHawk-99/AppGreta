package com.cda.contenu_seance.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFin;

    @ManyToOne
    private Centre centre;
    @ManyToOne
    private Formation formation;
    @OneToMany(mappedBy = "session")
    private List<Seance> seances;
    @ManyToMany
    private List<Formateur> formateurs;
    @ManyToOne
    private Coordinateur coordinateur;
}