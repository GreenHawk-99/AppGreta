package com.cda.contenu_seance.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDebut;
    //@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFin;
    private int dureeTotal;

    @ManyToOne
    private Centre centre;
    @ManyToOne
    private Formation formation;
    @OneToMany(mappedBy = "session")
    private List<Seance> seances;
    @ManyToMany(mappedBy = "sessions")
    private List<Formateur> formateurs;
    @ManyToOne
    private Coordinateur coordinateur;
}