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
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomCentre;
    private String adresseCentre;
    private String codesPostal;
    private String ville;

    @OneToMany(mappedBy = "centre", cascade = {CascadeType.PERSIST,CascadeType.DETACH})
    private List<Session> sessions;
    @ManyToMany
    private List<Coordinateur> coordinateurs;
}