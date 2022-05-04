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
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDuJour;
    private int duree;
    private String objectifPeda;
    private String methodeEnvisage;
    private String support;
    private String deroulement;

    @ManyToOne(fetch = FetchType.LAZY)
    private Formateur formateurs;
    @ManyToOne
    private Session session;
    @ManyToMany
    private List<SavoirFaire> savoirFaires;
    @ManyToOne
    private Evaluation evaluation;
}