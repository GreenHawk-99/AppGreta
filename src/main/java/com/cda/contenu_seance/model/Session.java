package com.cda.contenu_seance.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

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
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
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