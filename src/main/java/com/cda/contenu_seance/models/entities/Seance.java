package com.cda.contenu_seance.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

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
    private String evaluation;

    @Nullable
    @ManyToOne(fetch = FetchType.LAZY)
    private Formateur formateurs;
    @Nullable
    @ManyToOne
    private Session session;
    @Nullable
    @ManyToMany
    private List<SavoirFaire> savoirFaires;

    @Nullable
    public boolean getFormateurFicheVide(){
        return this.objectifPeda.isEmpty() ||
                this.methodeEnvisage.isEmpty() ||
                this.support.isEmpty() ||
                this.deroulement.isEmpty();
    }
    /*private boolean getFormateurFicheVide(){
        if (objectifPeda.isEmpty() || methodeEnvisage.isEmpty() || support.isEmpty() || deroulement.isEmpty()){
            return true;
        }else {
            return false;
        }
    }*/
}